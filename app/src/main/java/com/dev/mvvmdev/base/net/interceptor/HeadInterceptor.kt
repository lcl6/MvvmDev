package com.dev.mvvmdev.base.net.interceptor;

import okhttp3.Interceptor
import okhttp3.Response

/**
 * 头部信息拦截器
 * @Author liancl
 * @Date 2021/4/9 0009-10:43
 */
class HeadInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val newBuilder = chain.request().newBuilder()
        //添加头部信息
//        newBuilder.addHeader("token", "token123456").build()
        return chain.proceed(newBuilder.build())
    }
}