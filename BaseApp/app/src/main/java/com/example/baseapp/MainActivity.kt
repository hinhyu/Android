
package com.example.baseapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var button1 : Button //전역변수는 반드시 초기화 해줘야함, lateinit:초기화를 미룸
    lateinit var button_ds : Button
    lateinit var button_119 : Button
    lateinit var button_exit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("myCheck","안드로이드 출력")
        button1 = findViewById<Button>(R.id.btn1)
        button1.setOnClickListener {
            Log.d("myCheck","버튼1이 클릭됐어요")
            Toast.makeText(applicationContext,"버튼을 눌렀어요", Toast.LENGTH_SHORT).show()
        }

        button_ds = findViewById<Button>(R.id.btn_duksung)
        button_ds.setOnClickListener {
            Log.d("myCheck","버튼-홈페이지가 클릭됐어요")
            val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.duksung.ac.kr"))
            startActivity(mIntent)
            Toast.makeText(applicationContext,"덕성여자대학교 홈페이지", Toast.LENGTH_SHORT).show()
        }

        button_119 = findViewById<Button>(R.id.btn_tell)
        button_119.setOnClickListener {
            Log.d("myCheck","버튼-전화걸기가 클릭됐어요")
            val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:/119"))
            startActivity(mIntent)
            Toast.makeText(applicationContext,"119로 전화하기", Toast.LENGTH_SHORT).show()
        }

        button_exit = findViewById<Button>(R.id.btn_exit)
        button_exit.setOnClickListener{ finish() }
    }
}