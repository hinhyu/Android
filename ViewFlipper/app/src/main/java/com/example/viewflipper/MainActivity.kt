package com.example.viewflipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnPrev : Button
        var btnNext : Button
        var vFlipper : ViewFlipper

        btnPrev = findViewById<Button>(R.id.btnPrev)
        btnNext = findViewById<Button>(R.id.btnNext)
        vFlipper = findViewById<ViewFlipper>(R.id.viewFlipper1)

        btnPrev.setOnClickListener {
            vFlipper.showPrevious()
        }

        btnNext.setOnClickListener {
            vFlipper.showNext()
        }
    }
}
