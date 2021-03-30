package com.example.mvvmdev.manager

import retrofit2.http.*

/**
 *Created by liancl on 2021/3/30 0030.
 */

interface Apiserver {

    @GET("data/category/Girl/type/Girl/page/{page}/count/{count}")
    suspend fun  getGirlList(@Path("page") page: String,
                             @Path("count") count: String)


}