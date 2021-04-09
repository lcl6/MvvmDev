package com.dev.mvvmdev.base.net.interceptor

import com.dev.mvvmdev.base.appContext
import com.dev.mvvmdev.ui.ext.context.isNetworkAvailable
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author liancl
 * @Date 2021/3/30 0030-15:47
 */
class CacheInterceptor(var day: Int = 7) :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val newBuilder = request.newBuilder()

        if (!appContext.isNetworkAvailable()) {
            request = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()
        }
        val response = chain.proceed(request)
        if (!appContext.isNetworkAvailable()) {
            val maxAge = 60 * 60
            response.newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public, max-age=$maxAge")
                .build()
        } else {
            val maxStale = 60 * 60 * 24 * day // tolerate 1-weeks stale
            response.newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                .build()
        }
        return chain.proceed(newBuilder.build())
    }
}