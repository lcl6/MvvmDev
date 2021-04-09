package com.dev.mvvmdev.base;

import android.app.Activity
import androidx.fragment.app.Fragment
import com.dev.mvvm.widget.ProgressDialogHelper

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

