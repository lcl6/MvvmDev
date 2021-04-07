package com.dev.mvvmdev.vm

import BannerResponse
import androidx.lifecycle.MutableLiveData
import com.dev.mvvmdev.base.vm.request
import com.dev.mvvm.vm.BaseViewModel
import requestManger

/**
 *首页数据vm
 * @Author lianc;
 * @Date 2021/3/29 0029-15:37
 */
class HomeViewModel :BaseViewModel() {

    val bannerList:MutableLiveData<ArrayList<BannerResponse>> = MutableLiveData()

    fun getBanner(){
        request({ requestManger.getBanner()},{bannerList.value=it},{loadChange.showFail.value=("${it.mErrorCode}: ${it.mErrorMsg}")})
    }

}