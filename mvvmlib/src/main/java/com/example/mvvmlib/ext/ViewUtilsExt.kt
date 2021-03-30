package com.example.mvvmlib.ext

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mvvmlib.utils.ToastUtils

/**
 * view级 扩展函数
 * @Author liancl
 * @Date 2021/3/30 0030-9:24
 */
fun Activity.showToast(context: Context, message: String?, duration: Int = Toast.LENGTH_SHORT)=this.apply{
    ToastUtils.show(context,message,duration)
}

fun Fragment.showToast(context: Context, message: String?, duration: Int = Toast.LENGTH_SHORT)=this.apply{
    ToastUtils.show(context,message,duration)
}

fun Dialog.showToast(context: Context, message: String?, duration: Int = Toast.LENGTH_SHORT)=this.apply{
    ToastUtils.show(context,message,duration)
}
