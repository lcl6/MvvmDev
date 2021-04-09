package com.dev.mvvmdev.base.ui
import com.dev.mvvm.ac.BaseVmActivity
import com.dev.mvvm.ext.kLog
import com.dev.mvvm.vm.BaseViewModel
import com.dev.mvvmdev.base.disMissDialog
import com.dev.mvvmdev.base.showLoad

/**
 *
 * 基类不使用databinding
 * @Author liancl
 * @Date 2021/3/30 0030-9:09
 */
abstract class  BaseActivity<VM:BaseViewModel> : BaseVmActivity<VM>() {
    /**
     * 自定义弹窗
     * @param it String?
     */
    override fun showLoading(it: String) {
        showLoad(it)
        kLog.e("ac loading")
    }

    override fun showNoData(it: String) {
        dismiss()
    }

    override fun showFail(it: String) {
        dismiss()
    }

    override fun showSuccess(it: String) {
        dismiss()
    }

    private fun dismiss() {
        disMissDialog()
    }

}