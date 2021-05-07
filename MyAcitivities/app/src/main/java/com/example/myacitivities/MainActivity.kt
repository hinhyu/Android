package com.example.myacitivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.myacitivities.R

class MainActivity : AppCompatActivity() {
    var d = "액티비티 생명주기 테스트"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "그림 투표하기"

        Log.d(d,"OnCreate")

        // 1. 변수 선언
        var voteCount = IntArray(9)
        for (i in 0..8)
            voteCount[i] = 0
        // 9개의 이미지 버튼 객체배열
        var image = arrayOfNulls<ImageView>(9)

        // 2. 변수과 id 연결
        // 3. 동작
        var imageId = arrayOf(R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9)
        for (i in imageId.indices) {
            image[i] = findViewById<ImageView>(imageId[i])
            image[i]!!.setOnClickListener{
                voteCount[i]++
                Toast.makeText(applicationContext, ": 총 " + voteCount[i] + " 표", Toast.LENGTH_SHORT).show()
            }
        }
        // image[0] = findViewById<ImageView>(R.id.iv0)

        var imgName = arrayOf("독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서")

        var btnNewActivity = findViewById<Button>(R.id.btnResult)
        btnNewActivity.setOnClickListener {
            // SecondActivity로 이동,연결
            var intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("VoteCount",voteCount) // putExtra(넘겨받을 데이터이름,넘겨줄 데이터변수)
            intent.putExtra("ImageName", imgName)
            // startActivity(intent)
            startActivityForResult(intent, 0)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(d,"OnStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(d,"OnRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(d,"OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(d,"OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(d,"OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(d,"OnDestroy")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            var hap = data!!.getIntExtra("Hap",0)
            Toast.makeText(applicationContext, ": 총 " + hap + " 표", Toast.LENGTH_SHORT).show()
        }
    }
}