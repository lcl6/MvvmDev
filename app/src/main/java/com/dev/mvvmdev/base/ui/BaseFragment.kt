package com.dev.mvvmdev.base.ui
import com.dev.mvvm.fragment.BaseVmFragment
import com.dev.mvvm.vm.BaseViewModel

/**
 * 基本的fragment 不使用databinding
 * @Author liancl
 * @Date 2021/3/29 0029-17:24
 */
abstract class BaseFragment<VM:BaseViewModel> :BaseVmFragment<VM>(){

    override fun showLoading(msg: String?) {
    }


    override fun showNoData(it: String?) {
    }

    override fun showFail(it: String?) {
    }

    override fun showSuccess(it: String?) {
    }


}