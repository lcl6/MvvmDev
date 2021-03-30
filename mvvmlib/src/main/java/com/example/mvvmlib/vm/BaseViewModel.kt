package com.example.mvvmlib.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmlib.event.EventLiveData

/**
 * vm基类
 *Created by liancl on 2021/3/29 0029.
 */

open class BaseViewModel: ViewModel() {

    val loadChange by lazy { UiconfigChange() }
    inner class UiconfigChange{
        val showLoading by lazy { EventLiveData<String>() }
        val showSuccess by lazy { EventLiveData<String>() }
        val showFail by lazy { EventLiveData<String>() }
        val showNoData by lazy { EventLiveData<String>() }
    }
}