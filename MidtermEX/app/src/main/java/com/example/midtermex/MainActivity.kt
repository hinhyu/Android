package com.example.midtermex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

// 1변수선언 - 2id연결 - 3동작
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = VpagerAdapter(this)
        pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        pager.offscreenPageLimit = 4

        indicator.setViewPager(pager)
        indicator.createIndicators(4,0)

        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicator.animatePageSelected(position)
                Toast.makeText(applicationContext,"${position+1} 페이지 선택됨", Toast.LENGTH_LONG).show()
            }
        })
        button.setOnClickListener{
            pager.currentItem = 0
        }
        button2.setOnClickListener{
            pager.currentItem = 1
        }
        button3.setOnClickListener{
            pager.currentItem = 2
        }
        button4.setOnClickListener{
            pager.currentItem = 3
        }
        title = "그림 투표하기"

        //Log.d(d,"OnCreate")

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
}