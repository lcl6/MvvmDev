package com.dev.mvvmdev.base

import android.app.Application
import com.dev.mvvmdev.base.status.EmptyCallback
import com.dev.mvvmdev.base.status.ErrorCallback
import com.dev.mvvmdev.base.status.LoadingCallback
import com.dev.mvvmdev.base.status.TimeoutCallback
import com.kingja.loadsir.core.LoadSir

/**
 * app
 * @Author liancl
 * @Date 2021/4/6 0006-17:10
 */
 class App :Application() {
    override fun onCreate() {
        super.onCreate()

        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())//加载
            .addCallback(EmptyCallback())
            .addCallback(ErrorCallback())
            .addCallback(TimeoutCallback())
            .setDefaultCallback(LoadingCallback::class.java)
            .commit()
    }
}