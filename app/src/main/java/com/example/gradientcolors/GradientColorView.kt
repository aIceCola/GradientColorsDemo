/**
 * Copyright (C), 2020- 2050
 * FileName: GradientColorView
 * Author: Ice Cola
 * Date: 2020/10/11 20:24
 * Description: GradientColorView
 * History:
 * <author>       <time>       <version>      <desc>
 * Ice Cola       2020/10/11        1.0          GradientColorView
 */
package com.example.gradientcolors

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class GradientColorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val mRectRadius = context.resources.getDimension(R.dimen.radius)
    private val mPaint: Paint = Paint()
    private var mStartColor: Int? = null
    private var mEndColor: Int? = null

    init {
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        if (mStartColor == null || mEndColor == null) {
            return
        }
        val w: Float = measuredWidth.toFloat()
        val h: Float = measuredHeight.toFloat()
        val linearGradient =
            LinearGradient(0f, 0f, w, h, mStartColor!!, mEndColor!!, Shader.TileMode.CLAMP)
        val rectF = RectF(0f, 0f, w, h)
        mPaint.shader = linearGradient
        //角度从（0，0）到（w,h)的渐变色
        canvas?.drawRoundRect(rectF, mRectRadius, mRectRadius, mPaint);
    }

    fun setColor(startColor: Int, endColor: Int) {
        mStartColor = startColor
        mEndColor = endColor
    }
}