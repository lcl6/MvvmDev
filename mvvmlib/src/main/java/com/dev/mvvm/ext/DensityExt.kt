package com.dev.mvvm.ext

import android.content.Context
import android.util.TypedValue

/**
 * 单位换算
 * @Author liancl
 * @Date 2021/4/6 0006-15:56
 */

/**
 * dp 转 px
 * @param context Context 上下文
 * @return Int 返回值
 */
fun Float.dp2px(context: Context):Int{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, context.resources.displayMetrics) as Int
}

/**
 * dp 转 px
 * @param context Context 上下文
 * @return Int 返回值
 */
fun Int.dpF2px(context: Context):Float{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics)
}

/**
 * dp 转 px float
 * @receiver Float
 * @param context Context
 * @return Float
 */
fun Float.dp2pxFloat(context: Context):Float{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, context.resources.displayMetrics)
}

/**
 * px 转 dp
 * @receiver Float
 * @param context Context
 * @return Float
 */
fun Float.px2dp(context :Context): Float {
    val scale: Float = context.resources.displayMetrics.density
    return this / scale
}

/**
 * 获取屏幕宽
 * @receiver Context
 * @return Int
 */
fun Context.screenWidth(): Int {
   return resources.displayMetrics.widthPixels
}
/**
 * 获取屏幕高
 * @receiver Context
 * @return Int
 */
fun Context.screenHeight(): Int {
    return resources.displayMetrics.heightPixels
}


