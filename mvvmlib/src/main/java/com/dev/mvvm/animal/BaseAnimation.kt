package com.dev.mvvm.animal

import android.animation.Animator
import android.view.View

/**
 * 动画基类
 * Created by zhouL on 2018/6/28.
 */
interface BaseAnimation {
    
    fun getAnimators(view: View): Array<Animator>

    fun getDuration(): Int
}