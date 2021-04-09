package com.dev.mvvmdev.ui.ext.context;

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.fragment.app.Fragment
import com.dev.mvvm.widget.ProgressDialogHelper
import com.dev.mvvmdev.base.appContext


/**
 * ac fragment 逻辑扩展函数
 * @Author liancl
 * @Date 2021/4/9 0009-9:35
 */

/**
 * 简单的 dialog 扩展
 * @receiver Activity
 * @param msg String 显示的信息
 */
fun Activity.showLoad(msg:String){
    ProgressDialogHelper.get()
        .setCancelable(false)
        .setMsg(msg)
        .setCanceledOnTouchOutside(false)
        .create(this).show()
}

/**
 * 简单的dialog 消失
 * @receiver Activity
 */
fun Activity.disMissDialog(){
    ProgressDialogHelper.get().create(this).dismiss()
}


/**
 * 简单的 dialog 扩展
 * @receiver Fragment
 * @param msg String 显示的信息
 */
fun Fragment.showLoad(msg:String){
    activity?.let {
        ProgressDialogHelper.get()
        .setCancelable(false)
        .setMsg(msg)
        .setCanceledOnTouchOutside(false)
        .create(it).show()
    }
}

/**
 * 简单的dialog 消失
 * @receiver Fragment
 */
fun Fragment.disMissDialog(){
    activity?.let { ProgressDialogHelper.get().create(it).dismiss() }
}


/**
 * 判断网络是否可用
 * @receiver Context
 * @return Boolean
 */
fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager =
        appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
    } else {
        try {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                Log.i("update_statut", "Network is available : true")
                return true
            }
        } catch (e: Exception) {
            Log.i("update_statut", "" + e.message)
        }
    }
    Log.i("update_statut", "Network is available : FALSE ")
    return false
}