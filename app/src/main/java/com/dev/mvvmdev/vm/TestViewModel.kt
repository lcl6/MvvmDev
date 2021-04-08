package com.dev.mvvmdev.vm;

import androidx.lifecycle.MutableLiveData
import com.dev.mvvm.vm.BaseViewModel
import com.dev.mvvmdev.base.vm.request
import com.dev.mvvmdev.base.vm.requestUnCheck
import com.dev.mvvmdev.bean.BannerResponse
import com.dev.mvvmdev.bean.NewsBean
import requestManger

/**
 * @Author liancl
 * @Date 2021/4/7 0007-14:12
 */
class TestViewModel :BaseViewModel() {
     val dataBean :MutableLiveData<NewsBean> = MutableLiveData()
    val bannerList:MutableLiveData<ArrayList<BannerResponse>> = MutableLiveData()

    fun getBanner(){

        request({ requestManger.getBanner()},{bannerList.value=it},{loadChange.showFail.value=("${it.mErrorCode}: ${it.mErrorMsg}")})
    }

    fun getData(){
        requestUnCheck({requestManger.getTestData()},{
            dataBean.value=it
        },{})

    }


}