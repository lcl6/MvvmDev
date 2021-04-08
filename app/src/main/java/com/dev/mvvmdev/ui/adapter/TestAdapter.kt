package com.dev.mvvmdev.ui.adapter;

import android.content.Context
import com.dev.mvvmdev.R
import com.dev.mvvmdev.base.adapter.BaseDbRecyclerViewAdapter
import com.dev.mvvmdev.bean.BannerResponse
import com.dev.mvvmdev.databinding.ItemTestBinding

/**
 *
 * @Author liancl
 * @Date 2021/4/7 0007-17:19
 */
class TestAdapter(context: Context) :
    BaseDbRecyclerViewAdapter<BannerResponse, ItemTestBinding>(context){

    override fun getLayoutId(): Int {
        return  R.layout.item_test
    }

    override fun onDbBind(viewHolder:ViewDBHolder<ItemTestBinding>, position: Int) {
        val dataBinding = viewHolder.getDataBinding()
        dataBinding.itemdata=getData()?.get(position)
    }

}