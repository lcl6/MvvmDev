package com.dev.mvvmdev.api

import com.dev.mvvmdev.base.bean.response.ApiResponse
import com.dev.mvvmdev.bean.BannerResponse
import retrofit2.http.GET

/**
 *Created by liancl on 2021/3/30 0030.
 */

interface Apiserver {


    @GET("banner/json")
    suspend fun getBanner(): ApiResponse<ArrayList<BannerResponse>>

}