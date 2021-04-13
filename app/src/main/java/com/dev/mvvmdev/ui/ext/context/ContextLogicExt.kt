package com.dev.mvvmdev.ui.ext.context;

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.storage.StorageManager
import android.util.Log
import androidx.fragment.app.Fragment
import com.dev.mvvm.widget.ProgressDialogHelper
import com.dev.mvvmdev.base.App
import java.lang.reflect.Array


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
 * 跳转界面
 * @receiver Activity 需要跳转的界面
 */
inline fun <reified T:Activity>Activity.start(){
    val starter = Intent(this, T::class.java)
    this.startActivity(starter)
}



/**
 * 判断网络是否可用
 * @receiver Context
 * @return Boolean
 */
fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager =
        App.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
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


/** 获取应用程序名称 */
@JvmOverloads
fun Context.getAppName(packageName: String = getPackageName()): String {
    try {
        return resources.getString(packageManager.getPackageInfo(packageName, 0).applicationInfo.labelRes)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return ""
}

/** 获取客户端版本名称 */
@JvmOverloads
fun Context.getVersionName(packageName: String = getPackageName()): String {
    try {
        return packageManager.getPackageInfo(packageName, 0).versionName
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return ""
}

/** 获取客户端版本号 */
@JvmOverloads
fun Context.getVersionCode(packageName: String = getPackageName()): Long {
    try {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            packageManager.getPackageInfo(packageName, 0).longVersionCode
        } else {
            packageManager.getPackageInfo(packageName, 0).versionCode.toLong()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return -1
}

/** 获取APP的图标 */
fun Context.getAppIcon(packageName: String): Drawable? {
    try {
        val packageInfo: PackageInfo? = packageManager.getPackageInfo(packageName, 0)
        return packageInfo?.applicationInfo?.loadIcon(packageManager)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}


/** 获取存储路径，first为内置存储路径，second为外置存储路径 */
fun Context.getStoragePath(): Pair<String?, String?> {
    try {
        val storageManager = getSystemService(Context.STORAGE_SERVICE) as StorageManager
        val storageVolumeClass = Class.forName("android.os.storage.StorageVolume")
        val getVolumeList = storageManager.javaClass.getMethod("getVolumeList")
        val getPath = storageVolumeClass.getMethod("getPath")
        val isRemovable = storageVolumeClass.getMethod("isRemovable")
        val result = getVolumeList.invoke(storageManager) ?: return Pair(null, null)
        val length = Array.getLength(result)

        var internal: String? = null
        var external: String? = null

        for (i in 0 until length) {
            val storageVolumeElement = Array.get(result, i)
            val path: String? = getPath.invoke(storageVolumeElement) as String
            val removable: Boolean = isRemovable.invoke(storageVolumeElement) as Boolean
            if (!removable) {
                internal = path// 内置路径
                continue
            } else {
                external = path// 外置路径
                continue
            }
        }
        return Pair(internal, external)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return Pair(null, null)
}
