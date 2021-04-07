package com.dev.mvvmdev.base.bean.response

/**
 * @Author liancl
 * @Date 2021/3/31 0031-11:13
 */
 class ApiResponse<T>(private val  errorCode: Int, private val errorMsg: String, private val data: T ) : BaseResponse<T>() {
    override fun isSuccess(): Boolean {
       return errorCode==0
    }

    override fun getRequestCode(): Int {
         return errorCode
    }

    override fun getRequestMsg(): String {
        return errorMsg
    }

    override fun getRequestData(): T {
        return data
    }
}