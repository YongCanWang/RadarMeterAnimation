package com.trans.libradarmeter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author Tom灿
 * @description:
 * @date :2023/5/24 14:55
 */
public class RadarMaterViews extends View {
    private final Context context;

    public RadarMaterViews(Context context) {
        this(context, null);
    }

    public RadarMaterViews(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public RadarMaterViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public RadarMaterViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int verticalCenter = getHeight() / 2;
        int horizontalCenter = getWidth() / 2;
        new RadarMaterView(context, 100, Color.BLUE);
//        BitmapFactory.
    }
}
