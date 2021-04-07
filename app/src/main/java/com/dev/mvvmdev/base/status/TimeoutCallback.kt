package com.dev.mvvmdev.base.status;

import android.content.Context
import android.view.View
import com.dev.mvvmdev.R
import com.kingja.loadsir.callback.Callback

/**
 * 超时页回调页
 * @Author liancl
 * @Date 2021/4/7 0007-8:45
 */
class TimeoutCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.view_time_out_back
    }

    override fun onReloadEvent(context: Context?, view: View?): Boolean {
        return false
    }

}