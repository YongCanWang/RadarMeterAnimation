package com.trans.libradarmeter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;


/**
 * @author Tom灿
 * @description: 雷达波、水波纹
 * @date :2023/5/24 13:51
 */
public class RadarMaterLayout extends RelativeLayout {
    private final Context context;
    // 圆个数
    private int radarMaterLineSize = 1;
    // 圆半径
    private int circleRadius = 100;
    // 圆颜色
    private int circleColor = Color.BLUE;
    // 圆间距
    private int circleRadiusDistance = 100;
    // 动画持续时间
    private int animationDuration = 500;
    // 动画播放模式：0放大，1缩小
    private int animationMode = 0;


    public RadarMaterLayout(Context context) {
        this(context, null);
    }

    public RadarMaterLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public RadarMaterLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public RadarMaterLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    startAnimation((View) msg.obj);
                    break;
            }
        }
    };

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        for (int i = 0; i < radarMaterLineSize; i++) {
            circleRadius = circleRadiusDistance * (i + 1);
            RadarMaterView radarMaterView = new RadarMaterView(context, circleRadius, circleColor);
            addView(radarMaterView);
            radarMaterView.layout(0, 0, getWidth(), getHeight());
        }
    }

    /**
     * 设置圆（雷达）个数
     * @param size
     */
    public void setRadarMaterLineSize(int size) {
        this.radarMaterLineSize = size;
    }

    /**
     * 设置动画播放模式：0放大，1缩小
     * @param mode
     */
    public void setAnimationMode(int mode) {
        animationMode = mode;
    }

    /**
     * 设置圆颜色
     * @param color
     */
    public void setCircleColor(int color) {
        this.circleColor = color;
    }

    /**
     * 设置动画播放持续时间
     * @param duration
     */
    public void setAnimationDuration(int duration) {
        this.animationDuration = duration;
    }

    /**
     * 开启动画
     */
    public void start() {
        for (int i = 0; i < getChildCount(); i++) {
            Message message = handler.obtainMessage(0);
            message.what = 0;
            message.obj = getChildAt(i);
            handler.sendMessageDelayed(message, 100 * i);
        }
    }

    /**
     *  放大、缩小动画
     * @param view
     */
    private void startAnimation(View view) {
        ScaleAnimation animation = null;
        if (animationMode == 0) {
            animation = new ScaleAnimation(1.2f, 1.5f, 1.2f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        } else if (animationMode == 1) {
            animation = new ScaleAnimation(1.5f, 1.2f, 1.5f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        } else {
            animation = new ScaleAnimation(1.2f, 1.5f, 1.2f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        }
        animation.setDuration(animationDuration);
        animation.setFillAfter(true);
        animation.setRepeatCount(99999);
        animation.setRepeatMode(Animation.INFINITE);
        view.startAnimation(animation);
    }


}
