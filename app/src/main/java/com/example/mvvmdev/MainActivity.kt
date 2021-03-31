package com.example.mvvmdev

import BaseActivity
import HomeViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdev.databinding.ActivityMainBinding
import com.example.mvvmdev.manager.net.apiManger
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<HomeViewModel, ActivityMainBinding>() {

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