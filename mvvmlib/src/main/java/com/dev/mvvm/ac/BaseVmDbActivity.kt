package com.dev.mvvm.ac

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.dev.mvvm.vm.BaseViewModel

/**
 *
 * 采用databingding 的acitivity
 * @Author liacl
 * @Date 2021/3/29 0029-16:31
 */
abstract class BaseVmDbActivity<VM:BaseViewModel,DB:ViewDataBinding> : BaseVmActivity<VM>() {
    lateinit var mDatabind: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        useDataBinding(true)
        super.onCreate(savedInstanceState)
    }
    override fun initDataBinding() {
        mDatabind=  DataBindingUtil.setContentView(this,getLayoutId())
        mDatabind.lifecycleOwner=this
    }
}