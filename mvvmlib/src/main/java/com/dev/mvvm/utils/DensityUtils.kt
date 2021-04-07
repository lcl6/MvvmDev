package com.dev.mvvm.utils

import android.content.Context
import android.util.TypedValue

/**
 * 单位转换类
 * Created by zhouL on 2016/11/17.
 */
object DensityUtils {
    /**
     * dp转px
     * @param context 上下文
     * @param dpValue dp值
     */
    fun dp2px(context: Context, dpValue: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpValue,
            context.resources.displayMetrics
        ).toInt()
    }

    /**
     * dp转px
     * @param context 上下文
     * @param dpValue dp值
     */
    fun dp2pxFloat(context: Context, dpValue: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpValue,
            context.resources.displayMetrics
        )
    }

    /**
     * sp转px
     * @param context 上下文
     * @param spValue sp值
     */
    fun sp2px(context: Context, spValue: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            spValue,
            context.resources.displayMetrics
        ).toInt()
    }

    /**
     * sp转px
     * @param context 上下文
     * @param spValue sp值
     */
    fun sp2pxFloat(context: Context, spValue: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            spValue,
            context.resources.displayMetrics
        )
    }

    /**
     * px转dp
     * @param context 上下文
     * @param pxValue px值
     */
    fun px2dp(context: Context, pxValue: Float): Float {
        val scale = context.resources.displayMetrics.density
        return pxValue / scale
    }

    /**
     * px转sp
     * @param context 上下文
     * @param pxValue px值
     */
    fun px2sp(context: Context, pxValue: Float): Float {
        return pxValue / context.resources.displayMetrics.scaledDensity
    }
}