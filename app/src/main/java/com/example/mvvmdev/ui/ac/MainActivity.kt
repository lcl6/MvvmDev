package com.example.mvvmdev.ui.ac

import BaseDbActivity
import HomeViewModel
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmdev.R
import com.example.mvvmdev.databinding.ActivityMainBinding
import kLog

class MainActivity : BaseDbActivity<HomeViewModel, ActivityMainBinding>() {


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
        homeViewModel.getBanner()

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}