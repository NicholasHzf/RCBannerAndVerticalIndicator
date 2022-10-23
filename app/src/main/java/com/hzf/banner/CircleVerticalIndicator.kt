package com.hzf.banner

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import com.youth.banner.indicator.BaseIndicator

/**
 * @ClassName: CircleVerticalIndicator
 * @Description: banner 垂直圆点指示器
 * @Author: Nicholas.hzf
 * @Date: 2022/9/27 00:06 Created
 */
class CircleVerticalIndicator(context: Context,attributeSet: AttributeSet): BaseIndicator(context,attributeSet) {
    
    private var mNormalRadius = 0
    private var mSelectedRadius = 0
    private var maxRadius = 0

    init {
        // 外部设置的是直径的大小，所以半径处以 2
        mNormalRadius = config.normalWidth / 2
        mSelectedRadius = config.selectedWidth / 2
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val count = config.indicatorSize
        if (count <= 1) {
            return
        }
        mNormalRadius = config.normalWidth / 2
        mSelectedRadius = config.selectedWidth / 2
        // 考虑当选中和默认的大小不一样的情况
        maxRadius = mSelectedRadius.coerceAtLeast(mNormalRadius)

        // 高度 = 间距 *（总数-1）+ 选中直径 + 默认直径 *（总数-1）
        val height =
            (count - 1) * config.indicatorSpace + config.selectedWidth + config.normalWidth * (count - 1)
        setMeasuredDimension(maxRadius * 2, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val count = config.indicatorSize
        if (count <= 1) {
            return
        }
        var circleY = 0f
        for (i in 0 until count) {
            // 画笔颜色
            mPaint.color =
                if (config.currentPosition == i) config.selectedColor else config.normalColor
            // 圆的直径
            val circleDiameter =
                if (config.currentPosition == i) config.selectedWidth else config.normalWidth
            // 指示器圆圈半径
            val radius = if (config.currentPosition == i) mSelectedRadius else mNormalRadius
            // 绘制圆
            canvas.drawCircle(maxRadius.toFloat(),circleY + radius , radius.toFloat(), mPaint)
            // 更新最小的 y 值：当前的 y 加上当前圆的直径，加上间距
            circleY += (circleDiameter + config.indicatorSpace).toFloat()
        }
    }
    
}