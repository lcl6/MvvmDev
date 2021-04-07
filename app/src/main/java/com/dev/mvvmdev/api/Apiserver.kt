package com.dev.mvvmdev.api

import com.dev.mvvmdev.base.bean.response.ApiResponse
import BannerResponse
import retrofit2.http.*

/**
 *Created by liancl on 2021/3/30 0030.
 */

interface Apiserver {


    @GET("banner/json")
    suspend fun getBanner(): ApiResponse<ArrayList<BannerResponse>>

}