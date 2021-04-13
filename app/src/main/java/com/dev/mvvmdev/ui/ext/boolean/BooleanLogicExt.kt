package com.dev.mvvmdev.ui.ext.boolean;

/**
 * @Author liancl
 * @Date 2021/4/12 0012-16:50
 */

/**
 * infix 1.只有一个参数  2. 添加在方法前面  3. 必须是成员方法或者扩展方法
 */
/** 替代java三目运算符（condition ? a : b）为 condition.then { a } ?: b */
infix fun <T> Boolean.then(param: () -> T): T? = if (this) param() else null