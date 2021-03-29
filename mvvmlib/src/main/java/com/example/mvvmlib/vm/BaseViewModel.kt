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
        val showDialog by lazy { EventLiveData<String>() }
        val dissmissDialog by lazy { EventLiveData<Boolean>() }
    }
}