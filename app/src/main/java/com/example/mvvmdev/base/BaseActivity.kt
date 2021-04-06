package com.example.mvvmdev.base
import BaseVmActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.mvvmlib.ext.showToast
import com.example.mvvmlib.vm.BaseViewModel

/**
 *
 * 基类不使用databinding
 * @Author liancl
 * @Date 2021/3/30 0030-9:09
 */
abstract class  BaseActivity<VM:BaseViewModel> :BaseVmActivity<VM>() {

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
        showToast(this,it)
    }

    override fun showSuccess(it: String?) {
    }


}