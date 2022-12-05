package com.zx_tole.guyverwiki.presentation.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.zx_tole.guyverwiki.R


class ListItem(context: Context, attrs: AttributeSet)  : View(context, attrs) {
    private val textPaint: Paint = Paint()
    private var ta: TypedArray
    private val titleText: String
    private val textValueColor: Int
    private val textBgColor: Int
    private val drawable: Drawable?
    private val bitmap: Bitmap
    private val paint: Paint
    init {
        ta = context.obtainStyledAttributes(
            attrs,
            R.styleable.ListItem,
            0,
            0
        )

        titleText = ta.getString(R.styleable.ListItem_titleText).toString()

        val drawableId = ta.getResourceId(R.styleable.ListItem_src, -1)
        bitmap = BitmapFactory.decodeResource(resources, drawableId)
        drawable = ResourcesCompat.getDrawable(resources, drawableId, null)

        textBgColor = ta.getColor(
            R.styleable.ListItem_backgroundColor,
            Color.CYAN
        )

        textValueColor = ta.getColor(
            R.styleable.ListItem_valueColor,
            textBgColor
        )

        ta.recycle()
        paint = Paint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.isAntiAlias = true
        paint.isFilterBitmap = true
        paint.isDither = true
        canvas?.drawBitmap(bitmap, 0f, 0f, paint)

        textPaint.textSize = 48f * resources.displayMetrics.density
        textPaint.color = textBgColor
        textPaint.style = Paint.Style.FILL
        textPaint.alpha = 100
        canvas?.drawPaint(textPaint)


        textPaint.color = textValueColor

        canvas?.drawText(titleText, 96f, 96f * resources.displayMetrics.density, textPaint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val minW: Int = paddingLeft + paddingRight + 500
        val w = resolveSizeAndState(minW, widthMeasureSpec, 0)

        val minh: Int = paddingBottom + paddingTop + 500
        val h = resolveSizeAndState(minh, heightMeasureSpec, 0)
        setMeasuredDimension(w, h)
    }
}