package com.dev.mvvm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.dev.mvvm.vm.BaseViewModel

/**
 * 可以使用databinding
 * @Author liancl
 * @Date 2021/3/29 0029-15:26
 */
abstract class BaseVmDbfragment<VM:BaseViewModel,DB:ViewDataBinding> :BaseVmFragment<VM>(){

     lateinit var mDataBinding:DB
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding=DataBindingUtil.inflate(inflater,layoutId(),container,false)
        mDataBinding.lifecycleOwner=this
        return mDataBinding.root
    }

}