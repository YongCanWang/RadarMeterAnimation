package com.trans.libradarmeter;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author Tom灿
 * @description: 车道线
 * @date :2023/5/24 17:47
 */
public class LaneView extends View {
    private final Context context;

    public LaneView(Context context) {
        this(context, null);
    }

    public LaneView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public LaneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public LaneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
