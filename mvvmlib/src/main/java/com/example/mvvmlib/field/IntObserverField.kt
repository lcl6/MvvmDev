package com.example.mvvmlib.field

import androidx.databinding.ObservableField

/**
 * @Author liancl
 * @Date 2021/3/30 0030-10:49
 */
class IntObserverField(value:Int) :ObservableField<Int>(value) {
    override fun get(): Int {
        return super.get()!!
    }
}