package com.trans.radarmeteranimation

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var radmLeida: RadarMaterLayout? = null
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
    }


    private fun startAnimation() {
        radmLeida?.start()
    }
}