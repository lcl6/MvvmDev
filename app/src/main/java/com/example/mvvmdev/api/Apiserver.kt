package com.example.mvvmdev.api

import ApiResponse
import BannerResponse
import retrofit2.http.*

/**
 *Created by liancl on 2021/3/30 0030.
 */

interface Apiserver {


    @GET("banner/json1")
    suspend fun getBanner():ApiResponse<ArrayList<BannerResponse>>

}