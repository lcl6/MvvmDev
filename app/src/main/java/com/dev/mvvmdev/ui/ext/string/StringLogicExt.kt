package com.dev.mvvmdev.ui.ext.string;

import android.text.Editable
import com.dev.mvvmdev.ui.ext.boolean.then

/**
 * 字符串扩展函数
 * @Author liancl
 * @Date 2021/4/12 0012-16:47
 */

/** 把String转为Editable */
fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

/** 在String尾部进行文字拼接 */
fun <T> String.append(t: T?): String = StringBuilder(this).append((t != null) then { t } ?: "").toString()