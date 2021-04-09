package com.dev.mvvmdev.base.ui
import androidx.databinding.ViewDataBinding
import com.dev.mvvm.ext.kLog
import com.dev.mvvm.fragment.BaseVmDbfragment
import com.dev.mvvm.vm.BaseViewModel
import com.dev.mvvmdev.ui.ext.context.disMissDialog
import com.dev.mvvmdev.ui.ext.context.showLoad

/**
 * 基本的fragment 使用databinding
 * @Author liancl
 * @Date 2021/3/29 0029-17:24
 */
abstract class BaseDbFragment<VM:BaseViewModel,DB:ViewDataBinding> : BaseVmDbfragment<VM, DB>(){

    override fun showLoading(msg: String) {
        showLoad(msg)
        kLog.e("BaseDbFragment loading")
    }


    override fun showNoData(it: String?) {
        dismiss()
    }

    override fun showFail(it: String?) {
        dismiss()
    }

    override fun showSuccess(it: String?) {
        dismiss()
    }
    private fun dismiss() {
       disMissDialog()
    }


}