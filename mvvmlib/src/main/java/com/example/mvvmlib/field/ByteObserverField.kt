package com.example.mvvmlib.field

import androidx.databinding.ObservableField

/**
 * 为Observerable 添加默认值 避免取值为空
 * @Author liancl
 * @Date 2021/3/30 0030-10:44
 */

class ByteObserverField(value:Byte=0):ObservableField<Byte>(value) {
    override fun get(): Byte {
        return super.get()!!
    }
}