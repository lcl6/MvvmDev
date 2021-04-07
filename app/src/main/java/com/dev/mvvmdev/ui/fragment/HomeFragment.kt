package com.dev.mvvmdev.ui.fragment

import com.dev.mvvmdev.vm.HomeViewModel
import android.os.Bundle
import com.dev.mvvmdev.R
import com.dev.mvvmdev.base.ui.BaseDbFragment
import com.dev.mvvmdev.databinding.FgHomeBinding

/**
 *
 * @Author liancl
 * @Date 2021/3/29 0029-15:37
 */
class HomeFragment : BaseDbFragment<HomeViewModel, FgHomeBinding>(){

    override fun layoutId(): Int {
        return R.layout.fg_home
    }

    override fun initData() {
    }

    override fun creatObserver() {
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

}