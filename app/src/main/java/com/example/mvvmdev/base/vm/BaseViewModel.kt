package com.example.mvvmdev.base.vm

import com.example.mvvmdev.base.exception.AppException
import com.example.mvvmdev.base.bean.response.BaseResponse
import android.text.TextUtils
import androidx.lifecycle.viewModelScope
import com.example.mvvmdev.base.exception.handlerError
import com.example.mvvmlib.vm.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * vm 对数据处理
 * @Author liancl
 * @Date 2021/3/31 0031-13:44
 */

/**
 * 请求统一框架
 *  上拉刷新 下拉更多   不需要全局loading
 *  点击调用接口之类的  不需要全局loading
 *  第一次调用接口等   需要loading
 *
 * @receiver BaseViewModel
 * @param block SuspendFunction0<com.example.mvvmdev.base.bean.response.BaseResponse<T>>
 * @param success Function1<T, Unit>
 * @param error Function1<com.example.mvvmdev.base.exception.AppException, Unit>
 * @param loading String 如果为空 不显示loading 改loading 为局部的loading 类似加载框
 * @param loadingSuccess String  如果为空 不回调
 * @param loadingNoData String   如果
 * @return Job
 */
fun <T> BaseViewModel.request(
    block: suspend () -> BaseResponse<T>,
    success: (T) -> Unit,
    error:(AppException)->Unit,
    loading: String = "",
    loadingSuccess: String = "",
    loadingNoData: String = ""
): Job {
    return viewModelScope.launch {
        runCatching {
            if(!TextUtils.isEmpty(loading))loadChange.showLoading.postValue(loading);
            block()
        }.onSuccess {
            val data = it.getRequestData()
            success(data)
            if (it.isSuccess()) loadChange.showSuccess.postValue(loadingSuccess) else loadChange.showFail.postValue(it.getRequestMsg())
        }.onFailure {
            //错误统一处理 以及特殊处理
            error(it.handlerError())
        }
    }
}
