package com.example.mvvmdev.manager.net

import com.example.mvvmdev.api.Apiserver
import com.example.mvvmdev.contants.BASEURL

/**
 * 网络请求类
 * @Author liancl
 * @Date 2021/3/30 0030-15:51
 */

val apiManger by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    NetApiManger.INSTANCE.getApi(Apiserver::class.java,BASEURL)
}