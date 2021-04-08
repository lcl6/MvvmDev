package com.dev.mvvmdev.bean;

import com.dev.mvvm.field.StringObserverField

/**
 * @Author liancl
 * @Date 2021/4/7 0007-14:13
 */
class NewsBean {
    val name : StringObserverField =StringObserverField("")
    var title:String=""
    override fun toString(): String {
        return "NewsBean(name='$name', title='$title')"
    }



}