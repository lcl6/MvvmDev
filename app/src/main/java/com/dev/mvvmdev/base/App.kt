package com.dev.mvvmdev.base

import android.app.Application
import com.dev.mvvmdev.base.exception.CrashManager
import com.dev.mvvmdev.base.status.EmptyCallback
import com.dev.mvvmdev.base.status.ErrorCallback
import com.dev.mvvmdev.base.status.LoadingCallback
import com.dev.mvvmdev.base.status.TimeoutCallback
import com.dev.mvvmdev.ui.ac.WelcomeActivity
import com.dev.mvvmdev.utils.FileManager
import com.kingja.loadsir.core.LoadSir
import java.io.File

/**
 * app
 * @Author liancl
 * @Date 2021/4/6 0006-17:10
 */
 class App :Application() {

    companion object{
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
        //初始化加载页
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())//加载
            .addCallback(EmptyCallback())
            .addCallback(ErrorCallback())
            .addCallback(TimeoutCallback())
            .setDefaultCallback(LoadingCallback::class.java)
            .commit()
        //初始化文件管理
        FileManager.init(this)
        //初始化崩溃
        CrashManager.get()
            .setInterceptor(true)
            .setLogTag("hh")
            .setToastTips("程序崩溃，即将重启")
            .setSaveFolderPath(FileManager.getCrashFolderPath() + "crash" + File.separator)
            .setFileName(System.currentTimeMillis().toString() + ".txt")
            .setLauncherClass<WelcomeActivity>()
            .build()

    }
}