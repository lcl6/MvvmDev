package com.example.mvvmdev.manager.net

import com.example.mvvmdev.manager.interceptor.CacheInterceptor
import com.example.mvvmdev.manager.interceptor.LogInterceptor
import com.example.mvvmdev.manager.interceptor.NetWorkInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 *
 * 网路请求配置
 * @Author liancl
 * @Date 2021/3/30 0030-15:31
 */
class NetApiManger private constructor(){
    companion object{
        val INSTANCE by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED){
            NetApiManger()
        }
    }

    /**
     * 获取api类
     * @param clazz Class<T> 需要传的类
     * @param baseUrl String 地址
     * @return T
     */
     fun <T>getApi(clazz: Class<T>,baseUrl:String):T{
         return Retrofit.Builder()
             .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))//数据返回json
//             .addCallAdapterFactory(RxJava2CallAdapterFactory)//是否支持rxjava
             .baseUrl(baseUrl)
             .client(okHttpClient)
             .build()
             .create(clazz)
     }


    private val okHttpClient:OkHttpClient
    get() {
       return OkHttpClient().newBuilder()
           .addNetworkInterceptor(NetWorkInterceptor())//添加网络拦截器
           .addInterceptor(LogInterceptor())//添加日志拦截器
//           .cache()//设置缓存
           .addInterceptor(CacheInterceptor())//添加缓存拦截器
           .connectTimeout(30, TimeUnit.SECONDS)
           .readTimeout(10,TimeUnit.SECONDS)
           .writeTimeout(10,TimeUnit.SECONDS)
           .build()
    }


}