package com.trans.radarmeteranimation

import android.graphics.Color
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.trans.libradarmeter.RadarMaterLayout

class MainActivity : AppCompatActivity() {
    var radmLeida: RadarMaterLayout? = null
    var ivTranslate: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radmLeida = findViewById(R.id.rml_leida)
        val btAnimation = findViewById<Button>(R.id.bt_animation)
        btAnimation.setOnClickListener {
            startAnimation()
        }
        radmLeida?.setRadarMaterLineSize(3)
        radmLeida?.setCircleColor(Color.BLACK)

        ivTranslate = findViewById<ImageView>(R.id.iv_translate)
    }


    private fun startAnimation() {
        radmLeida?.setAnimationDuration(800)
        radmLeida?.setAnimationMode(1)
        radmLeida?.start()
        startTranslateAnimation()
    }

    /**
     * 平移动画
     */
    private fun startTranslateAnimation() {
        val translate = TranslateAnimation(
            Animation.RELATIVE_TO_SELF,
            0.0f,
            Animation.RELATIVE_TO_SELF,
            0.0f,
            Animation.RELATIVE_TO_SELF,
            0.0f,
            Animation.RELATIVE_TO_SELF,
            3.0f
        )
        translate.duration = 2000  // 动画持续时长
        translate.repeatMode = Animation.RESTART // 动画重复模式
        translate.repeatCount = 99999 // 动画重复次数
        ivTranslate?.startAnimation(translate)
    }


}