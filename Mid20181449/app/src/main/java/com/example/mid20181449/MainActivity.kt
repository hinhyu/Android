package com.example.mid20181449

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var btnEnd : Button
    lateinit var calView : CalendarView
    lateinit var tvYear : TextView
    lateinit var tvMonth : TextView
    lateinit var tvDay : TextView
    lateinit var name : EditText
    lateinit var result : TextView
    lateinit var result2 : TextView
    lateinit var nametv : String
    lateinit var rdoGroup : RadioGroup

    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0

    var d = "액티비티 생명주기 테스트"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(d,"OnCreate")

        var btnPrev : Button
        var btnNext : Button
        var vFlipper : ViewFlipper

        btnEnd = findViewById<Button>(R.id.btnEnd)
        calView = findViewById<CalendarView>(R.id.calendarView1)
        tvYear = findViewById<TextView>(R.id.tvYear)
        tvMonth = findViewById<TextView>(R.id.tvMonth)
        tvDay = findViewById<TextView>(R.id.tvDay)
        name = findViewById<EditText>(R.id.name)
        result = findViewById<TextView>(R.id.result)
        result2 = findViewById<TextView>(R.id.result2)

        btnPrev = findViewById<Button>(R.id.btnPrev)
        btnNext = findViewById<Button>(R.id.btnNext)
        vFlipper = findViewById<ViewFlipper>(R.id.viewFlipper1)

        result2.visibility = View.INVISIBLE

        btnPrev.setOnClickListener {
            vFlipper.showPrevious()
        }

        btnNext.setOnClickListener {
            vFlipper.showNext()
        }

        calView.setOnDateChangeListener{ calendarView, i, i2, i3 ->
            result.visibility = View.INVISIBLE
            result2.visibility = View.VISIBLE

            nametv = name.text.toString()

            result2.text = nametv.toString()

            selectYear = i
            selectMonth = i2 + 1
            selectDay = i3

            tvYear.text = Integer.toString(selectYear)
            tvMonth.text = selectMonth.toString()
            tvDay.text = selectDay.toString()
        }
        btnEnd.setOnClickListener {
            var dlg = AlertDialog.Builder(this@MainActivity)

            var dialogView = View.inflate(this@MainActivity, R.layout.grade, null)
            dlg.setView(dialogView)
            dlg.setTitle("예약 정보 입력")
            dlg.setPositiveButton("확인"){dialog, which ->

                rdoGroup = dialogView.findViewById<RadioGroup>(R.id.rGroup)
                when(rdoGroup.checkedRadioButtonId){
                    R.id.rdo3 -> result2.text = name.text.toString() + "\n3학년"
                    R.id.rdo4 -> result2.text = name.text.toString() + "\n4학년"
                    else -> Snackbar.make(it, "학년을 먼저 선택하세요.", Snackbar.LENGTH_LONG).show()
                }
            }
            dlg.setNegativeButton("취소"){dialog, which ->
                Snackbar.make(it, "취소했습니다.", Snackbar.LENGTH_LONG).show()
            }
            dlg.show()
        }
        // ---------------------------------- //
        // 1. 변수 선언
        var voteCount = IntArray(3)
        for (i in 0..2)
            voteCount[i] = 0
        // 3개의 이미지 버튼 객체배열
        var image = arrayOfNulls<ImageView>(3)

        // 2. 변수과 id 연결
        // 3. 동작
        var imageId = arrayOf(R.id.iv1, R.id.iv2, R.id.iv3)
        for (i in imageId.indices) {
            image[i] = findViewById<ImageView>(imageId[i])
            image[i]!!.setOnClickListener{
                voteCount[i]++
                Toast.makeText(applicationContext, ": 총 " + voteCount[i] + " 표", Toast.LENGTH_SHORT).show()
            }
        }
        // image[0] = findViewById<ImageView>(R.id.iv0)

        var imgName = arrayOf("dog", "cat", "rabbit")

        var btnNewActivity = findViewById<Button>(R.id.btnVote)
        btnNewActivity.setOnClickListener {
            // SecondActivity로 이동,연결
            var intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("VoteCount",voteCount) // putExtra(넘겨받을 데이터이름,넘겨줄 데이터변수)
            intent.putExtra("ImageName", imgName)
            // startActivity(intent)
            startActivityForResult(intent, 0)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            var hap = data!!.getIntExtra("Hap",0)
            Toast.makeText(applicationContext, ": 총 " + hap + " 표", Toast.LENGTH_SHORT).show()
        }
    }
}
