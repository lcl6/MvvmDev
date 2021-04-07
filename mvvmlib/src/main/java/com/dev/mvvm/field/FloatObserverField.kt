package com.dev.mvvm.field

import androidx.databinding.ObservableField

/**
 * @Author liancl
 * @Date 2021/3/30 0030-10:48
 */
class FloatObserverField(value:Float=0f) :ObservableField<Float>(value){
    override fun get(): Float {
        return super.get()!!
    }
}