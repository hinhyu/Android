package com.example.myacitivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView

class SecondActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        // 0. intent 값 전달 받음
        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")

        // 1. 변수
        // 9개의 TextView, RatingBar 객체배열
        var tv = arrayOfNulls<TextView>(imageName!!.size) // size = 9
        var rbar = arrayOfNulls<RatingBar>(imageName.size)

        // 2. 변수 - id
        // 9개의 TextView, RatingBar ID 배열
        var tvID = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9)
        var rbarID = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9)
        for (i in voteResult!!.indices) {   // i in 0 .. 8
            tv[i] = findViewById<TextView>(tvID[i])
            rbar[i] = findViewById<RatingBar>(rbarID[i])
        }
        // tv[0] = findViewById<TextView>(R.id.tv1)
        // rbar[0] = findViewById<RatingBar>(R.id.rbar1)

        // 3. 동작
        for (i in voteResult!!.indices) {
            tv[i]!!.setText(imageName[i])
            rbar[i]!!.setRating(voteResult[i].toFloat())
        }

        var hapValue = 0
        for (i in 0 until voteResult.size) {
            hapValue += voteResult!![i]
        }

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", hapValue)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }
}