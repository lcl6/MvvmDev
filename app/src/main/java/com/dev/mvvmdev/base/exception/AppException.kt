package com.dev.mvvmdev.base.exception

/**
 *
 * 错误的基本格式
 * @Author liancl
 * @Date 2021/4/2 0002-9:59
 */
class AppException: Exception {

    var mErrorMsg:String
    var mErrorCode:Int
    lateinit var mErrorLog:String

    constructor( errorMsg:String,errorCode:Int,errorLog:String=""):super(){
        mErrorMsg= errorMsg
        mErrorCode=errorCode
        mErrorLog=errorLog
    }


}