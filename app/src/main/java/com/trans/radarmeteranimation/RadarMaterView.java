package com.trans.radarmeteranimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author Tom灿
 * @description:
 * @date :2023/5/24 13:44
 */
public class RadarMaterView extends View {
    private Paint paint;
    private int verticalCenter;
    private int horizontalCenter;
    private float circleRadius = 100;
    private int circleColor = Color.BLUE;

    public RadarMaterView(Context context) {
        this(context, null);
    }


    public RadarMaterView(Context context, int circleRadius, int circleColor) {
        this(context);
        this.circleRadius = circleRadius;
        this.circleColor = circleColor;
    }

    public RadarMaterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public RadarMaterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public RadarMaterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(circleColor);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        verticalCenter = getHeight() / 2;
        horizontalCenter = getWidth() / 2;
        canvas.drawCircle(horizontalCenter, verticalCenter, circleRadius, paint);
    }

    public void setCircleRadius(float radius) {
        circleRadius = radius;
    }

    public void setCircleColor(int color) {
        circleColor = color;
    }
}
