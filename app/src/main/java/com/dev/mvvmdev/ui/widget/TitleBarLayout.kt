package com.dev.mvvmdev.ui.widget

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.*
import androidx.core.content.ContextCompat
import com.dev.mvvmdev.R
import com.dev.mvvmdev.ui.widget.titlebar.TitleBarLayoutConfig
import com.dev.mvvm.ext.dp2px
import com.dev.mvvm.ext.px2dp
import com.dev.mvvm.utils.DensityUtils.px2sp

/**
 * 标题栏布局
 * Created by zhouL on 2016/11/17.
 */
class TitleBarLayout : LinearLayout {
    /** 标题栏配置  */
    private val mConfig = TitleBarLayoutConfig()

    /** 返回按钮布局  */
    private var mBackLayout: LinearLayout? = null

    /** 返回按钮  */
    private var mBackBtn: TextView? = null

    /** 标题  */
    private var mTitleTextView: TextView? = null

    /** 扩展区布局  */
    private var mExpandLinearLayout: LinearLayout? = null

    /** 分割线  */
    private var mDivideLineView: View? = null

    constructor(context: Context?) : super(context) {
        init(null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        init(attrs)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        findViews()
        config(attrs)
    }

    private fun findViews() {
        LayoutInflater.from(context).inflate(R.layout.component_view_title_layout, this)
        mBackLayout = findViewById(R.id.back_layout)
        mBackBtn = findViewById(R.id.back_btn)
        mTitleTextView = findViewById(R.id.title_textview)
        mExpandLinearLayout = findViewById(R.id.expand_layout)
        mDivideLineView = findViewById(R.id.divide_line)
    }

    private fun config(attrs: AttributeSet?) {
        var typedArray: TypedArray? = null
        if (attrs != null) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBarLayout)
        }

        // 默认显示返回按钮
        needBackButton(
            typedArray?.getBoolean(
                R.styleable.TitleBarLayout_isNeedBackBtn,
                mConfig.isNeedBackBtn
            )
                ?: mConfig.isNeedBackBtn
        )
        val backDrawable =
            typedArray?.getDrawable(R.styleable.TitleBarLayout_backDrawable)
        if (backDrawable != null) {
            mBackBtn!!.setCompoundDrawablesWithIntrinsicBounds(backDrawable, null, null, null)
        } else if (mConfig.backBtnResId != 0) {
            mBackBtn!!.setCompoundDrawablesWithIntrinsicBounds(mConfig.backBtnResId, 0, 0, 0)
        }
        val backText =
            if (typedArray == null) "" else typedArray.getString(R.styleable.TitleBarLayout_backText)
        if (!TextUtils.isEmpty(backText)) {
            setBackBtnName(backText)
        } else if (!TextUtils.isEmpty(mConfig.backBtnText)) {
            setBackBtnName(mConfig.backBtnText)
        }
        val backTextColor =
            typedArray?.getColorStateList(R.styleable.TitleBarLayout_backTextColor)
        if (backTextColor != null) {
            setBackBtnTextColor(backTextColor)
        } else if (mConfig.backBtnTextColor != 0) {
            setBackBtnTextColor(mConfig.backBtnTextColor)
        }
        val backTextSize = typedArray?.getDimensionPixelSize(
            R.styleable.TitleBarLayout_backTextSize,
            0
        )
            ?: 0
        if (backTextSize != 0) {
            setBackBtnTextSize(px2sp(context, backTextSize.toFloat()))
        } else if (mConfig.backBtnTextSize != 0) {
            setBackBtnTextSize(mConfig.backBtnTextSize.toFloat())
        }
        val titleText =
            if (typedArray == null) "" else typedArray.getString(R.styleable.TitleBarLayout_titleText)
        if (!TextUtils.isEmpty(titleText)) {
            setTitleName(titleText)
        }
        val titleTextColor =
            typedArray?.getColorStateList(R.styleable.TitleBarLayout_titleTextColor)
        if (titleTextColor != null) {
            setTitleTextColor(titleTextColor)
        } else if (mConfig.titleTextColor != 0) {
            setTitleTextColor(mConfig.titleTextColor)
        }
        val titleTextSize = typedArray?.getDimensionPixelSize(
            R.styleable.TitleBarLayout_titleTextSize,
            0
        )
            ?: 0
        if (titleTextSize != 0) {
            setTitleTextSize(px2sp(context, titleTextSize.toFloat()))
        } else if (mConfig.titleTextSize != 0) {
            setTitleTextSize(mConfig.titleTextSize.toFloat())
        }
        val isShowDivideLine =
            typedArray?.getBoolean(
                R.styleable.TitleBarLayout_isShowDivideLine,
                mConfig.isShowDivideLine
            )
                ?: mConfig.isShowDivideLine
        mDivideLineView!!.visibility = if (isShowDivideLine) View.VISIBLE else View.GONE
        val divideLineDrawable =
            typedArray?.getDrawable(R.styleable.TitleBarLayout_divideLineColor)
        if (divideLineDrawable != null) {
            setDivideLineColor(divideLineDrawable)
        } else if (mConfig.divideLineColor != 0) {
            setDivideLineColor(mConfig.divideLineColor)
        }
        val divideLineHeight = typedArray?.getDimensionPixelSize(
            R.styleable.TitleBarLayout_divideLineHeight,
            0
        )
            ?: 0
        if (divideLineHeight > 0) {
            setDivideLineHeight(divideLineHeight.toFloat().px2dp(context))
        } else if (mConfig.divideLineHeight > 0) {
            setDivideLineHeight(mConfig.divideLineHeight.toFloat())
        }
        val drawableBackground =
            typedArray?.getDrawable(R.styleable.TitleBarLayout_titleBarBackground)
        if (drawableBackground != null) {
            background = drawableBackground
        } else if (mConfig.backgroundResId != 0) {
            setBackgroundResource(mConfig.backgroundResId)
        } else {
            setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    if (mConfig.backgroundColor == 0) android.R.color.holo_blue_light else mConfig.backgroundColor
                )
            )
        }
        val isNeedElevation =
            typedArray?.getBoolean(
                R.styleable.TitleBarLayout_isNeedElevation,
                mConfig.isNeedElevation
            )
                ?: mConfig.isNeedElevation
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && isNeedElevation) {
            val elevationVale =
                typedArray?.getDimensionPixelSize(
                    R.styleable.TitleBarLayout_elevationVale,
                    0
                )
                    ?: 0
            elevation = if (elevationVale != 0) elevationVale.toFloat() else mConfig.elevationVale
        }

        // 默认不需要右侧扩展区域
        needExpandView(
            typedArray != null && typedArray.getBoolean(
                R.styleable.TitleBarLayout_isNeedExpandView,
                false
            )
        )
        val expandViewId = typedArray?.getResourceId(
            R.styleable.TitleBarLayout_expandViewId,
            0
        ) ?: 0
        if (expandViewId > 0) {
            val view =
                LayoutInflater.from(context).inflate(expandViewId, null)
            view?.let { addExpandView(it) }
        }
        typedArray?.recycle()
    }

    /**
     * 需要显示返回按钮
     * @param isNeed 是否需要
     */
    fun needBackButton(isNeed: Boolean) {
        mBackLayout!!.visibility = if (isNeed) View.VISIBLE else View.GONE
    }

    /**
     * 设置返回按钮的透明度
     * @param alpha 透明度
     */
    fun setBackButtonAlpha(@FloatRange(from = 0.0, to = 1.0) alpha: Float) {
        mBackLayout!!.alpha = alpha
    }

    /** 请重写实现返回按钮监听  */
    fun setOnBackBtnClickListener(listener: OnClickListener?) {
        mBackLayout!!.setOnClickListener(listener)
    }

    /**
     * 替换默认的返回按钮
     * @param view 返回按钮的View
     */
    fun replaceBackBtn(view: View?) {
        mBackLayout!!.removeAllViews()
        mBackLayout!!.addView(view)
    }

    /**
     * 设置返回按钮文字
     * @param str 文字描述
     */
    fun setBackBtnName(str: String?) {
        mBackBtn!!.text = str
    }

    /**
     * 设置返回按钮文字
     * @param strResId 文字资源id
     */
    fun setBackBtnName(@StringRes strResId: Int) {
        mBackBtn!!.text = context.getString(strResId)
    }

    /**
     * 设置返回按钮文字颜色
     * @param colorRes 颜色资源id
     */
    fun setBackBtnTextColor(@ColorRes colorRes: Int) {
        mBackBtn!!.setTextColor(ContextCompat.getColor(context, colorRes))
    }

    /**
     * 设置返回按钮文字颜色
     * @param color 颜色
     */
    fun setBackBtnTextColorInt(@ColorInt color: Int) {
        mBackBtn!!.setTextColor(color)
    }

    /**
     * 设置返回按钮文字颜色
     * @param colorStateList 颜色
     */
    fun setBackBtnTextColor(colorStateList: ColorStateList?) {
        if (colorStateList == null) {
            return
        }
        mBackBtn!!.setTextColor(colorStateList)
    }

    /**
     * 设置返回按钮文字大小
     * @param size 文字大小（单位sp）
     */
    fun setBackBtnTextSize(size: Float) {
        mBackBtn!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
    }

    /**
     * 设置标题名
     * @param title 标题名
     */
    fun setTitleName(title: String?) {
        mTitleTextView!!.text = title
    }

    /**
     * 设置标题名
     * @param strResId 文字资源id
     */
    fun setTitleName(@StringRes strResId: Int) {
        mTitleTextView!!.text = context.getString(strResId)
    }

    /**
     * 设置标题文字颜色
     * @param colorRes 颜色资源id
     */
    fun setTitleTextColor(@ColorRes colorRes: Int) {
        mTitleTextView!!.setTextColor(ContextCompat.getColor(context, colorRes))
    }

    /**
     * 设置标题文字颜色
     * @param color 颜色
     */
    fun setTitleTextColorInt(@ColorInt color: Int) {
        mTitleTextView!!.setTextColor(color)
    }

    /**
     * 设置文字颜色
     * @param colorStateList 颜色
     */
    fun setTitleTextColor(colorStateList: ColorStateList?) {
        if (colorStateList == null) {
            return
        }
        mTitleTextView!!.setTextColor(colorStateList)
    }

    /**
     * 设置标题文字大小
     * @param size 文字大小（单位sp）
     */
    fun setTitleTextSize(size: Float) {
        mTitleTextView!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
    }

    /**
     * 设置标题的透明度
     * @param alpha 透明度
     */
    fun setTitleAlpha(@FloatRange(from = 0.0, to = 1.0) alpha: Float) {
        mTitleTextView!!.alpha = alpha
    }

    /**
     * 需要右侧扩展区
     * @param isNeed 是否需要
     */
    fun needExpandView(isNeed: Boolean) {
        mExpandLinearLayout!!.visibility = if (isNeed) View.VISIBLE else View.GONE
    }

    /**
     * 添加扩展区域的View
     * @param view 控件
     */
    fun addExpandView(view: View?) {
        mExpandLinearLayout!!.addView(view)
        needExpandView(true)
    }

    /** 获取扩展区域的View  */
    val expandView: View?
        get() = mExpandLinearLayout

    /** 隐藏分割线  */
    fun goneDivideLine() {
        mDivideLineView!!.visibility = View.GONE
    }

    /** 设置分割线颜色  */
    fun setDivideLineColor(@ColorRes colorRes: Int) {
        mDivideLineView!!.setBackgroundColor(ContextCompat.getColor(context, colorRes))
    }

    /** 设置分割线颜色  */
    fun setDivideLineColorInt(@ColorInt color: Int) {
        mDivideLineView!!.setBackgroundColor(color)
    }

    /** 设置分割线颜色  */
    fun setDivideLineColor(drawable: Drawable?) {
        mDivideLineView!!.background = drawable
    }

    /**
     * 设置分割线高度
     * @param height 高度（单位dp）
     */
    fun setDivideLineHeight(height: Float) {
        val layoutParams = mDivideLineView!!.layoutParams
        layoutParams.height = height.dp2px(context)
        mDivideLineView!!.layoutParams = layoutParams
    }
}