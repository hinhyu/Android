package com.example.mypet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var chkAgree : CheckBox
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoDog : RadioButton
    lateinit var rdoCat : RadioButton
    lateinit var rdoRabbit : RadioButton
    lateinit var btnOk : Button
    lateinit var imgPet : ImageView
    lateinit var tvPet : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chkAgree = findViewById<CheckBox>(R.id.chkAgree)
        rGroup1 = findViewById<RadioGroup>(R.id.Rgroup)
        rdoDog = findViewById<RadioButton>(R.id.rDog)
        rdoCat = findViewById<RadioButton>(R.id.rCat)
        rdoRabbit = findViewById<RadioButton>(R.id.rRabbit)
        btnOk = findViewById<Button>(R.id.btnOK)
        imgPet = findViewById<ImageView>(R.id.imgPet)
        tvPet = findViewById<TextView>(R.id.tv2)

        chkAgree.setOnCheckedChangeListener{ compoundButton, b ->
            if(chkAgree.isChecked == true){
                rGroup1.visibility = android.view.View.VISIBLE
                btnOk.visibility = android.view.View.VISIBLE
                imgPet.visibility = android.view.View.VISIBLE
                tvPet.visibility = android.view.View.VISIBLE
            }else{
                rGroup1.visibility = android.view.View.INVISIBLE
                btnOk.visibility = android.view.View.INVISIBLE
                imgPet.visibility = android.view.View.INVISIBLE
                tvPet.visibility = android.view.View.INVISIBLE
            }
        }

        btnOk.setOnClickListener{
            when(rGroup1.checkedRadioButtonId){
                R.id.rDog -> imgPet.setImageResource(R.drawable.dog)
                R.id.rCat -> imgPet.setImageResource(R.drawable.cat)
                R.id.rRabbit -> imgPet.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(applicationContext, "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}