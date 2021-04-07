package com.dev.mvvm.ext

import android.util.Log

/**
 * 日志简单封装
 * @Author liancl
 * @Date 2021/4/2 0002-11:28
 */

val kLog by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
    Klog()
}
class Klog {
    private var mEnable: Boolean=true
    var mTag: String="KlogValue";

    fun setTag(tag:String){
        mTag=tag
    }
    fun logEnable(enable:Boolean){
        mEnable=enable
    }

    fun i(msg:String){
        if(!mEnable){
            return
        }
        Log.i(mTag,msg)
    }
    fun d(msg:String){
        if(!mEnable){
            return
        }
        Log.d(mTag,msg)
    }

    fun v(msg:String){
        if(!mEnable){
            return
        }
        Log.v(mTag,msg)
    }
    fun e(msg:String){
        if(!mEnable){
            return
        }
        Log.e(mTag,msg)
    }

    fun w(msg:String){
        if(!mEnable){
            return
        }
        Log.w(mTag,msg)
    }

}