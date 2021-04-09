package com.dev.mvvm.adapter;

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.dev.mvvm.viewholder.BaseDbViewHolder

/**
 * databinding 基类适配器
 * @Author liancl
 * @Date 2021/4/8 0008-8:34
 */
abstract class BaseDbRecyclerViewAdapter<T, DB : ViewDataBinding>(context: Context) :BaseRecyclerViewAdapter<T>(context = context) {
    override fun onBind(holder: RecyclerView.ViewHolder, position: Int) {
        onDbBind(holder as ViewDBHolder<DB>,position)
    }

    abstract fun onDbBind(viewHolder: ViewDBHolder<DB>, position: Int)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = DataBindingUtil.inflate<DB>(
            LayoutInflater.from(context),
            getLayoutId(),
            parent,
            false
        )
        return ViewDBHolder<DB>(
            inflate
        )
    }

    class ViewDBHolder<DB :ViewDataBinding>(dataBinding: DB) : BaseDbViewHolder<DB>(dataBinding)

    abstract fun getLayoutId(): Int


}