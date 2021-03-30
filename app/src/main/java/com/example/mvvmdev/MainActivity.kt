package com.example.mvvmdev

import BaseActivity
import HomeViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmdev.databinding.ActivityMainBinding

class MainActivity : BaseActivity<HomeViewModel,ActivityMainBinding>() {

    override fun cretObserver() {
    }

    override fun initView(savedInstanceState: Bundle?) {
        showLoading("加载中...")
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}