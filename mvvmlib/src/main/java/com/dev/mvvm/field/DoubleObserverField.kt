package com.dev.mvvm.field

import androidx.databinding.ObservableField

/**
 * @Author liancl
 * @Date 2021/3/30 0030-10:46
 */
class DoubleObserverField(value:Double=0.0) :ObservableField<Double>(value) {
    override fun get(): Double {
        return super.get()!!
    }
}