package com.dev.mvvmdev.ui.ac;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.mvvm.ext.kLog
import com.dev.mvvmdev.R
import com.dev.mvvmdev.base.ui.BaseDbActivity
import com.dev.mvvmdev.databinding.ActivityTestBinding
import com.dev.mvvmdev.ui.adapter.TestAdapter
import com.dev.mvvmdev.vm.TestViewModel
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir

/**
 * 测试databinding
 * @Author liancl
 * @Date 2021/4/7 0007-14:09
 */
class TestAcitvity : BaseDbActivity<TestViewModel,ActivityTestBinding>() {
   private lateinit var register:LoadService<Any>
    private val testAdapter: TestAdapter = TestAdapter(this)
    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, TestAcitvity::class.java)
            context.startActivity(starter)
        }
    }

    private val testViewModel:TestViewModel by viewModels()

    override fun creatObserver() {
        testViewModel.dataBean.observe(this, Observer {
//            register.showSuccess()
            mDatabind.newsBean=it
        })
        testViewModel.bannerList.observe(this, Observer {
            mDatabind.dataList=it
            register.showSuccess()
            kLog.e(it.toString())
            testAdapter.setData(it)
            testAdapter.notifyDataSetChanged()
        })


    }

    override fun initView(savedInstanceState: Bundle?) {

        mDatabind.recycleView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        mDatabind.recycleView.adapter=testAdapter
        register = LoadSir.getDefault().register(findViewById<ViewGroup>(R.id.vg_content))
        testViewModel.getData()
        testViewModel.getBanner()




    }
    override fun getLayoutId(): Int {
        return R.layout.activity_test
    }
}