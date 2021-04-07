package com.dev.mvvmdev.ui.ac

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.dev.mvvm.ext.kLog
import com.dev.mvvmdev.R
import com.dev.mvvmdev.base.status.ErrorCallback
import com.dev.mvvmdev.base.status.LoadingCallback
import com.dev.mvvmdev.base.ui.BaseDbActivity
import com.dev.mvvmdev.databinding.ActivityMainBinding
import com.dev.mvvmdev.vm.HomeViewModel
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import kotlinx.coroutines.*
class MainActivity : BaseDbActivity<HomeViewModel, ActivityMainBinding>() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main + Job())
    private lateinit var register:LoadService<Any>
    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }
    private  val homeViewModel: HomeViewModel by viewModels()

    override fun creatObserver() {
        homeViewModel.bannerList.observe(this, Observer {
            kLog.e(it.toString() )
        })
    }

    override fun initView(savedInstanceState: Bundle?) {
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view)

        homeViewModel.getBanner()

        register = LoadSir.getDefault().register(recyclerView) {
            coroutineScope.launch {
                register.showCallback(LoadingCallback::class.java)
                delay(2000)
                register.showSuccess()
            }

        }

        coroutineScope.launch {
            delay(3000)
//            register.showSuccess()
            register.showCallback(ErrorCallback::class.java)
//            register.showCallback(EmptyCallback::class.java)
        }


    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}