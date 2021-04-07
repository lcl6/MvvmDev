package com.dev.mvvm.ext;

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 * 和上下文有关的扩展类
 * @Author liancl
 * @Date 2021/4/7 0007-11:28
 */

@ColorInt
fun Context.getColorCompat(@ColorRes id: Int): Int = ContextCompat.getColor(this, id)

fun Context.getDrawableCompat(@DrawableRes id: Int): Drawable? = ContextCompat.getDrawable(this, id)

@ColorInt
fun View.getColorCompat(@ColorRes id: Int): Int = ContextCompat.getColor(context, id)

fun View.getDrawableCompat(@DrawableRes id: Int): Drawable? = ContextCompat.getDrawable(context, id)
