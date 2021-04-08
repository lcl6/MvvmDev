package com.dev.mvvm.viewholder;

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @Author liancl
 * @Date 2021/4/7 0007-17:33
 */
open class BaseDbViewHolder<DB>(dataBinding: DB) :RecyclerView.ViewHolder((dataBinding as ViewDataBinding).root) {
    private var mDataBinding:DB = dataBinding
    open fun getDataBinding(): DB {
        return mDataBinding
    }

    open fun setDataBinding(dataBinding: DB) {
        mDataBinding = dataBinding
    }
}