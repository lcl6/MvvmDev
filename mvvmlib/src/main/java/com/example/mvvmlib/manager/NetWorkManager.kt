package com.example.mvvmlib.manager

import NetState
import com.example.mvvmlib.event.EventLiveData

/**
 *Created by liancl on 2021/3/29 0029.
 */

public class NetWorkManager private constructor(){
    val mNetWorkManager =EventLiveData<NetState>()
    companion object{
        val INSTANCE:NetWorkManager by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED){
            NetWorkManager()
        }
    }

}