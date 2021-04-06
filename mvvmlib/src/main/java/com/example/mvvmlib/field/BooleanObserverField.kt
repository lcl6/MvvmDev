package com.example.mvvmlib.field

import androidx.databinding.ObservableField

/**
 *
 *自定义boolean 类型 ObservableField 提供了了默认值 避免取数据返回空判断
 * @Author liancl
 * @Date 2021/3/30 0030-10:40
 */
class BooleanObserverField(value:Boolean=false) : ObservableField<Boolean>(value){
    override fun get(): Boolean {
        return super.get()!!
    }
}