package com.dev.mvvmdev.ui.widget.titlebar

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

/**
 * 标题栏配置
 * Created by zhouL on 2017/7/4.
 */
class TitleBarLayoutConfig {
    /** 获取是否需要显示返回按钮  */
    /** 是否需要显示返回按钮  */
    var isNeedBackBtn = true
        private set

    /** 获取替换默认的返回按钮  */
    /** 替换默认的返回按钮资源图片  */
    @get:DrawableRes
    @DrawableRes
    var backBtnResId = 0
        private set

    /** 获取返回按钮文字  */
    /** 返回按钮文字  */
    var backBtnText = ""
        private set

    /** 获取返回按钮文字颜色  */
    /**
     * 设置返回按钮文字颜色
     * @param colorRes 颜色资源id
     */
    /** 返回按钮文字颜色  */
    @get:ColorRes
    @ColorRes
    var backBtnTextColor = 0

    /** 获取返回按钮文字大小  */
    /**
     * 设置返回按钮文字大小
     * @param size 文字大小（单位sp）
     */
    /** 返回按钮文字大小  */
    var backBtnTextSize = 0

    /** 获取标题文字颜色  */
    /**
     * 设置标题文字颜色
     * @param colorRes 颜色资源id
     */
    /** 标题文字颜色  */
    @get:ColorRes
    @ColorRes
    var titleTextColor = 0

    /** 获取标题文字大小  */
    /**
     * 设置标题文字大小
     * @param size 文字大小（单位sp）
     */
    /** 标题文字大小  */
    var titleTextSize = 0

    /** 获取是否显示分割线  */
    /**
     * 是否显示分割线
     * @param isShow 是否显示
     */
    /** 是否显示分割线  */
    var isShowDivideLine = false

    /** 获取分割线颜色  */
    /**
     * 设置分割线颜色
     * @param colorRes 色值
     */
    /** 分割线颜色  */
    @get:ColorRes
    @ColorRes
    var divideLineColor = 0

    /** 获取分割线高度  */
    /**
     * 设置分割线高度
     * @param height 高度（单位dp）
     */
    /** 分割线高度  */
    var divideLineHeight = 0

    /** 获取背景颜色  */
    /**
     * 设置背景颜色
     * @param colorRes 色值
     */
    /** 背景颜色  */
    @get:ColorRes
    @ColorRes
    var backgroundColor = 0

    /** 获取背景资源图片  */
    /**
     * 设置背景资源图片
     * @param resId 资源图片id
     */
    /** 背景资源图片  */
    @get:DrawableRes
    @DrawableRes
    var backgroundResId = 0

    /** 获取是否需要阴影  */
    /**
     * 是否需要阴影
     * @param isNeed 是否需要
     */
    /** 是否需要阴影  */
    var isNeedElevation = true

    /** 获取阴影的值  */
    /**
     * 设置阴影的值（单位px）
     * @param elevationVale 阴影值
     */
    /** 阴影的值  */
    var elevationVale = 12f

    /**
     * 需要显示返回按钮
     * @param isNeed 是否需要
     */
    fun setNeedBackButton(isNeed: Boolean) {
        isNeedBackBtn = isNeed
    }

    /**
     * 替换默认的返回按钮
     * @param resId 返回按钮的资源id
     */
    fun setReplaceBackBtnResId(@DrawableRes resId: Int) {
        backBtnResId = resId
    }

    /**
     * 设置返回按钮文字
     * @param str 文字描述
     */
    fun setBackBtnName(str: String) {
        backBtnText = str
    }

}