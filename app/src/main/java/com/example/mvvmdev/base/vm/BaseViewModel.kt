package com.example.mvvmdev.base.vm

import ApiResponse
import AppException
import BaseResponse
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
fun <T> BaseViewModel.request(
    block: suspend () -> BaseResponse<T>,
    success: (T) -> Unit,
    error:(AppException)->Unit,
    loading: String = "加载中",
    loadingSuccess: String = "成功",
    loadingNoData: String = "暂无数据"
): Job {
    return viewModelScope.launch {
        runCatching {
            loadChange.showLoading.postValue(loading);
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
