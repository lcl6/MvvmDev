package com.dev.mvvmdev.manager.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * 网络拦截器
 * @Author liancl
 * @Date 2021/3/30 0030-15:42
 */
class NetWorkInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val newBuilder = chain.request().newBuilder()
        //拦截操作

        return chain.proceed(newBuilder.build())
    }
}