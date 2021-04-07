package com.dev.mvvmdev.base.status;

import com.dev.mvvmdev.R
import com.kingja.loadsir.callback.Callback

/**
 * 加载中回调页
 * @Author liancl
 * @Date 2021/4/7 0007-8:45
 */
class LoadingCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.view_loading_back
    }


}