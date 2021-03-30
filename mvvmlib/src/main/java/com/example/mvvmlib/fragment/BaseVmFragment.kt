package com.example.mvvmlib.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmlib.ext.getVmClazz
import com.example.mvvmlib.manager.net.NetWorkManager
import com.example.mvvmlib.utils.UiHandler
import com.example.mvvmlib.vm.BaseViewModel

/**
 * 懒加载fragment
 *Created by liancl on 2021/3/29 0029.
 */
abstract class BaseVmFragment<VM : BaseViewModel> :Fragment(){

    /**是否是第一次加载**/
    private  var mIsFirst: Boolean=true

    lateinit var mViewModel:VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(layoutId(), container, false)
    }

    /**
     * 布局id
     */
    abstract fun layoutId(): Int

    override fun onResume() {
        super.onResume()
        onVisiable()

    }

    /**
     * 懒加载判断
     */
    private fun onVisiable() {

        if(lifecycle.currentState== Lifecycle.State.STARTED&&mIsFirst){
            UiHandler.postDelayed(Runnable {
                lazyLoadData()
                NetWorkManager.INSTANCE.mNetWorkManager.observeInFragment(this, Observer {
                    onNetWorkChange()
                })
            },lazaLoadTime())
        }

    }

    /**
     * 网络变化监听
     */
    private fun onNetWorkChange() {

    }

    /**
     * 懒加载获取数据
     */
    open fun lazyLoadData(){

    }
    /**
     * 懒加载时间
     */
    open fun lazaLoadTime(): Long=300

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mIsFirst=true
        mViewModel = creatViewModel()
        initView(savedInstanceState)
        creatObserver()
        initUiConfig(mViewModel)
        initData()
        setListener()

    }

    /**
     * 给没有在fragment 绑定的vm添加监听事件
     * @param viewModels Array<out BaseViewModel>
     */
    fun addLoadingObserver(vararg viewModels: BaseViewModel){
        viewModels.forEach {
            initUiConfig(it)
        }
    }

    /**
     * 显示空数据
     * @param it String?
     */
    abstract fun showNoData(it: String?)

    /**
     * 显示结果
     * @param it String?
     */
    abstract fun showResult(it: String?)

    /**
     * 事件绑定
     */
    open fun setListener(){

    }

    /**
     *页面请求配置
     */
    private fun initUiConfig(viewModel: BaseViewModel) {
       viewModel.apply {
            loadChange.showLoading.observeInFragment(this@BaseVmFragment, Observer {
                showLoading(it)
            })
            loadChange.showResult.observeInFragment(this@BaseVmFragment, Observer {
                showResult(it)
            })
            loadChange.showNoData.observeInFragment(this@BaseVmFragment, Observer {
                showNoData(it)
            })
        }

    }


    /**
     * 请求中
     */
    abstract fun showLoading(msg: String?="请稍等...")

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 创建观察者
     */
    abstract fun creatObserver()
    /**
     * 获取VM
     */
    private fun creatViewModel():VM {
        return ViewModelProvider(this).get(getVmClazz(this))

    }

    /**
     * 初始化组件
     */
    abstract fun initView(savedInstanceState: Bundle?)

}