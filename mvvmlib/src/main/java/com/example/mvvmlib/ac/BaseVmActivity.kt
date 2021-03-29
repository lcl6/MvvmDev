import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmlib.ext.getVmClazz
import com.example.mvvmlib.manager.net.NetWorkManager
import com.example.mvvmlib.vm.BaseViewModel

/**
 * @Author liancl
 * @Date 2021/3/29 0029-16:07
 */
abstract class BaseVmActivity<VM:BaseViewModel>:AppCompatActivity() {
    private  var isUseDb: Boolean=false
    lateinit var mViewModel:VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isUseDb) {
            initDataBinding()
        }else{
            setContentView(getLayoutId())
        }
        init(savedInstanceState)

    }

    private fun init(savedInstanceState: Bundle?) {

        mViewModel= creatViewModel()
        initView(savedInstanceState)
        initUiConfig()
        cretObserver()
        initData()
        setListener()
        NetWorkManager.INSTANCE.mNetWorkManager.observeInActivity(this, Observer {
            onNetWorkChange()
        })
    }

    /**
     * 初始化页面配置
     */
    private fun initUiConfig() {
        mViewModel.loadChange.showDialog.observeInActivity(this, Observer {
            showLoading(it)
        })
        mViewModel.loadChange.dissmissDialog.observeInActivity(this, Observer {
            disMissDialog(it)
        })

    }

    /**
     * 隐藏dialog
     * @param it Boolean?
     */
    abstract fun disMissDialog(it: Boolean?)

    /**
     * 显示dialog
     * @param it String?
     */
    abstract fun showLoading(it: String?="请稍等...")

    /**
     * 网络变化监听
     */
    open fun onNetWorkChange() {

    }

    /**
     * 生成观察者
     */
    abstract fun cretObserver()

    /**
     * 生成VM
     * @return VM
     */
    private fun creatViewModel() :VM{
       return ViewModelProvider(this).get(getVmClazz(this))
    }

    /**
     * 事件绑定
     */
    open fun setListener() {
    }

    /**
     * 初始化数据
     */
    open fun initData() {

    }

    /**
     * 初始化
     * @param savedInstanceState Bundle?
     */
    abstract fun initView(savedInstanceState: Bundle?)

    /**
     * 初始化databinding
     */
    open fun initDataBinding() {
    }

    /**
     * 布局id
     * @return Int
     */
    abstract fun getLayoutId(): Int

    /**
     * 是否使用dataBinding
     * @param useDb Boolean
     */
    fun useDataBinding(useDb:Boolean){
        isUseDb=useDb
    }
    /**
     * 给没有在 activity 绑定的vm添加监听事件
     * @param viewModels Array<out BaseViewModel>
     */
    fun addLoadingObserver(vararg viewModels: BaseViewModel){
        viewModels.forEach {
            it.loadChange.showDialog.observeInActivity(this, Observer {
                showLoading(it)
            })
            it.loadChange.dissmissDialog.observeInActivity(this, Observer {
                disMissDialog(it)
            })
        }
    }
}