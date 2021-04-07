package com.dev.mvvmdev.manager.net

import com.dev.mvvmdev.api.Apiserver
import com.dev.mvvmdev.contants.BASEURL

/**
 * 网络请求类
 * @Author liancl
 * @Date 2021/3/30 0030-15:51
 */

val apiManger by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    NetApiManger.INSTANCE.getApi(Apiserver::class.java,BASEURL)
}