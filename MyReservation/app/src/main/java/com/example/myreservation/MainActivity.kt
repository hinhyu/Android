package com.example.myreservation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var chrono : Chronometer
    lateinit var btnStart : Button
    lateinit var btnEnd : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
    lateinit var calView : CalendarView
    lateinit var tPicker: TimePicker
    lateinit var tvYear : TextView
    lateinit var tvMonth : TextView
    lateinit var tvDay : TextView
    lateinit var tvHour : TextView
    lateinit var tvMinute : TextView

    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById<Button>(R.id.btnStart)
        btnEnd = findViewById<Button>(R.id.btnEnd)
        chrono = findViewById<Chronometer>(R.id.chronometer1)
        rdoCal = findViewById<RadioButton>(R.id.rdoCal)
        rdoTime = findViewById<RadioButton>(R.id.rdoTime)
        tPicker = findViewById<TimePicker>(R.id.timePicker1)
        calView = findViewById<CalendarView>(R.id.calendarView1)
        tvYear = findViewById<TextView>(R.id.tvYear)
        tvMonth = findViewById<TextView>(R.id.tvMonth)
        tvDay = findViewById<TextView>(R.id.tvDay)
        tvHour = findViewById<TextView>(R.id.tvHour)
        tvMinute = findViewById<TextView>(R.id.tvMinute)

        //처음에는 2개를 안보이게 설정
        tPicker.visibility = android.view.View.INVISIBLE
        calView.visibility = View.INVISIBLE
        rdoCal.setOnClickListener{
            calView.visibility = View.VISIBLE
            tPicker.visibility = View.INVISIBLE
        }
        rdoTime.setOnClickListener{
            calView.visibility = View.INVISIBLE
            tPicker.visibility = View.VISIBLE
        }

        calView.setOnDateChangeListener{ calendarView, i, i2, i3 ->
            selectYear = i
            selectMonth = i2 + 1
            selectDay = i3
        }
        btnStart.setOnClickListener{
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)
        }
        btnEnd.setOnClickListener{
            chrono.stop()
            chrono.setTextColor(Color.BLUE)

            tvYear.text = Integer.toString(selectYear)
            tvMonth.text = selectMonth.toString()
            tvDay.text = selectDay.toString()

            tvHour.text = Integer.toString(tPicker.hour)//currentHour) //minSDK23이상인 경우만 사용할 수 있음
            tvMinute.text = Integer.toString(tPicker.minute)//currentMinute)
        }
    }
}