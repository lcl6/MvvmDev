package com.dev.mvvmdev.base.status;

import android.content.Context
import android.view.View
import com.dev.mvvmdev.R
import com.kingja.loadsir.callback.Callback

/**
 * 空白页回调页
 * @Author liancl
 * @Date 2021/4/7 0007-8:45
 */
class EmptyCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.view_empty_back
    }

    override fun onReloadEvent(context: Context?, view: View?): Boolean {
        return false
    }

}