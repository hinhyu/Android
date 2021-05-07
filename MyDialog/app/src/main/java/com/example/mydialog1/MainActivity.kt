package com.example.mydialog1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener{
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("제목입니다")
            dlg.setIcon(R.mipmap.ic_launcher)
            //dlg.setMessage("이곳이 내용입니다")

            var versionArray = arrayOf("오레오", "파이", "큐(10)")
            //dlg.setItems(versionArray){dialog, which ->
            // dlg.setSingleChoiceItems(versionArray, 0){ dialog, which ->
            var checkarr = booleanArrayOf(true, false, false)
            dlg.setMultiChoiceItems(versionArray, checkarr){ dialog, which, isChecked ->
                button1.text = versionArray[which]
            }

            //dlg.setPositiveButton("확인", null)
            dlg.setPositiveButton("확인"){
                dialog, which ->
                Snackbar.make(it, "확인버튼", Snackbar.LENGTH_LONG).show()
            }
            dlg.setNegativeButton("닫기", null)
            dlg.show()
        }
    }
}