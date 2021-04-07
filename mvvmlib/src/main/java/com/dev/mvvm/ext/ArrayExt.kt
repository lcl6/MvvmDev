package com.dev.mvvm.ext;

/**
 * @Author liancl
 * @Date 2021/4/7 0007-10:45
 */

/** 获取数组长度 */
fun Array<*>?.getSize(): Int = this?.size ?: 0

/** 获取列表长度 */
fun Collection<*>?.getSize(): Int = this?.size ?: 0