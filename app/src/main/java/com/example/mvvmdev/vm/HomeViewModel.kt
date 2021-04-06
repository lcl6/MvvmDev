package com.example.mvvmdev.vm

import BannerResponse
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdev.base.vm.request
import com.example.mvvmlib.vm.BaseViewModel
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