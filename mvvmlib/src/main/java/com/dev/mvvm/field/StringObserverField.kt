package com.dev.mvvm.field

import androidx.databinding.ObservableField

/**
 * @Author liancl
 * @Date 2021/3/30 0030-10:53
 */
class StringObserverField(value:String) :ObservableField<String>(value) {
    override fun get(): String {
        return super.get()!!
    }
}