package com.dev.mvvmdev.ui.ext.view;

import android.content.Context
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.mvvm.adapter.BaseDbRecyclerViewAdapter
import com.dev.mvvm.adapter.BaseRecyclerViewAdapter
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir

/**
 * view 逻辑扩展函数
 * @Author liancl
 * @Date 2021/4/8 0008-16:15
 */

/**
 * databinding recyclerVIew 简单使用扩展函数
 * @param context Context 上下文
 * @param mAdapter BaseDbRecyclerViewAdapter<T, DB> 继承的适配器
 * @param vertical Boolean 是否是竖直
 */
fun <T,DB : ViewDataBinding>RecyclerView.initDb(context: Context, mAdapter: BaseDbRecyclerViewAdapter<T, DB>, vertical:Boolean=true ){
    layoutManager=  if(vertical)LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false) else LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    adapter=mAdapter
}

/**
 * recyclerVIew 简单使用扩展函数
 * @param context Context
 * @param mAdapter BaseRecyclerViewAdapter<T>
 * @param vertical Boolean 是否是竖直
 */
fun <T>RecyclerView.init(context: Context,mAdapter: BaseRecyclerViewAdapter<T>,vertical:Boolean=true ){
    layoutManager=  if(vertical)LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false) else LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    adapter=mAdapter
}

/**
 * 简单使用扩展  单纯为了减少代码
 * @receiver View
 * @param reload Function0<Unit>
 * @return LoadService<Any>
 */
fun View.initLoadSir(reload:()->Unit):LoadService<Any>{
    return LoadSir.getDefault().register(this){
        reload()
    }
}
