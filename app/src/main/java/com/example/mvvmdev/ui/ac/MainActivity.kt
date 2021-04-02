package com.example.mvvmdev.ui.ac

import BaseActivity
import HomeViewModel
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmdev.R
import com.example.mvvmdev.databinding.ActivityMainBinding

class MainActivity : BaseActivity<HomeViewModel, ActivityMainBinding>() {


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
            Log.e("homeViewModel", it.toString())
        })
    }

    override fun initView(savedInstanceState: Bundle?) {
        homeViewModel.getBanner()

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}