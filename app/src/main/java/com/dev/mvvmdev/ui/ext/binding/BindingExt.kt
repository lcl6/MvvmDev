package com.dev.mvvmdev.ui.ext.binding;

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * 自定义绑定
 * @Author
 * @Date 2021/4/8 0008-9:48
 */
@BindingAdapter("img_url")
fun bindImage(imageView: ImageView, url:String){
    if(url.isEmpty()){
        return
    }
    Glide.with(imageView.context).load(url).into(imageView);
}

/**
 * 防止 textview 因为数据为null 问题
 * @param textView TextView
 * @param text String
 */
@BindingAdapter("text_null")
fun bindText(textView: TextView,text:String){
    if(text.isEmpty()){
        return
    }
    val replace = text.replace("null", "", true)
    textView.text = replace
}
