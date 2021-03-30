package com.example.mvvmdev

import BaseActivity
import HomeViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmdev.databinding.ActivityMainBinding
import com.example.mvvmdev.manager.net.apiManger
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<HomeViewModel,ActivityMainBinding>() {

    override fun cretObserver() {
    }

    override fun initView(savedInstanceState: Bundle?) {
        showLoading("加载中...")

        GlobalScope.launch {
            apiManger.getGirlList("1","10")
        }

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}