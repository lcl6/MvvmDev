package com.dev.mvvmdev.vm;

import androidx.lifecycle.MutableLiveData
import com.dev.mvvm.vm.BaseViewModel
import com.dev.mvvmdev.base.vm.request
import com.dev.mvvmdev.base.vm.requestUnCheck
import com.dev.mvvmdev.bean.BannerResponse
import com.dev.mvvmdev.bean.NewsBean
import kotlinx.coroutines.*
import requestManger

/**
 * @Author liancl
 * @Date 2021/4/7 0007-14:12
 */
class TestViewModel :BaseViewModel() {
     val dataBean :MutableLiveData<NewsBean> = MutableLiveData()
    val bannerList:MutableLiveData<ArrayList<BannerResponse>> = MutableLiveData()

    val crash:MutableLiveData<Boolean> = MutableLiveData()

    fun getBanner(){

        request({ requestManger.getBanner()},{bannerList.value=it},{loadChange.showFail.value=("${it.mErrorCode}: ${it.mErrorMsg}")})
    }

    fun getData(){

        requestUnCheck({requestManger.getTestData()},{
            dataBean.value=it
        },{})

    }
    fun clickTest(){
        loadChange.showLoading.postValue("加载中...")

        val coroutineScope = CoroutineScope(Dispatchers.IO + Job())
        coroutineScope.launch {
            delay(3000)
            loadChange.showSuccess.postValue("")
        }

    }

    fun clickCrash(){
        crash.value=true
        val string:String="1"
        val get = string[8]

    }

}