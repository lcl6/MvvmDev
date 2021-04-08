package com.dev.mvvmdev.base.ui

import androidx.databinding.ViewDataBinding
import com.dev.mvvm.ac.BaseVmDbActivity
import com.dev.mvvm.vm.BaseViewModel

/**
 *
 * 基类依赖于databindin
 * @Author liancl
 * @Date 2021/3/30 0030-9:09
 */
abstract class  BaseDbActivity<VM:BaseViewModel,DB:ViewDataBinding> : BaseVmDbActivity<VM, DB>() {

    /**
     * 自定义弹窗
     * @param it String?
     */
    override fun showLoading(it: String?) {
//        showToast(this,it)
    }

    override fun showNoData(it: String?) {
    }

    override fun showFail(it: String?) {
//        showToast(this,it)
    }

    override fun showSuccess(it: String?) {
    }


}