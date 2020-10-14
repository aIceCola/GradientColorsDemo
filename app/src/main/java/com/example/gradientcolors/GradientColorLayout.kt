/**
 * Copyright (C), 2020- 2050
 * FileName: GradientColors
 * Author: Ice Cola
 * Date: 2020/9/26 22:29
 * Description: GradientColors
 * History:
 * <author>       <time>       <version>      <desc>
 * Ice Cola       2020/9/26        1.0          GradientColors
 */
package com.example.gradientcolors

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout

class GradientColorLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private val mSize = context.resources.getDimension(R.dimen.color_size).toInt()

    init {
        initColor()
    }

    private fun initColor() {
        val startColor = resources.getStringArray(R.array.gradient_start)
        val endColor = resources.getStringArray(R.array.gradient_end)
        for (i in startColor.indices) {
            val view = getView(Color.parseColor(startColor[i]), Color.parseColor(endColor[i]))
            addView(view)
        }
    }

    private fun getView(startColor: Int, endColor: Int): GradientColorView {
        val gradientColorView = GradientColorView(context)
        val layoutParams = LayoutParams(mSize, mSize)
        layoutParams.leftMargin = context.resources.getDimension(R.dimen.color_margin).toInt()
        gradientColorView.setColor(startColor, endColor)
        gradientColorView.layoutParams = layoutParams
        return gradientColorView
    }
}