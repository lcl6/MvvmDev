package com.dev.mvvmdev.ui.binding;

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * 自定义绑定
 * @Author
 * @Date 2021/4/8 0008-9:48
 */
//
@BindingAdapter("imgurl")
fun bindImage(imageView: ImageView, url:String){
    if(url.isEmpty()){
        return
    }
    Glide.with(imageView.context).load(url).into(imageView);
}