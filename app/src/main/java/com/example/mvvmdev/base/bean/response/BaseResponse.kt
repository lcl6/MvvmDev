package com.example.mvvmdev.base.bean.response

/**
 *
 * 基本的包装
 * @Author liancl
 * @Date 2021/3/31 0031-11:09
 */
abstract class BaseResponse<T> {
    /**
     * 判断接口是否成功返回
     * @return Boolean
     */
    abstract fun isSuccess(): Boolean
    abstract fun getRequestCode(): Int

    /**
     * 接口返回的错误信息
     * @return String
     */
    abstract fun getRequestMsg(): String

    /**
     * 返回
     * @return T
     */
    abstract fun getRequestData(): T

}