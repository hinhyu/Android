package com.example.myphpjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            recycleView.layoutManager = LinearLayoutManager(this)
            fetchJson("http://172.30.1.38/PHP_connection.php")
        }
    }

    fun fetchJson(myurl : String){
        val url = URL(myurl)
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.d("hInfo","Failed to execute request!")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                Log.d("hInfo", "Success to execute request! : $body")

                val gson = GsonBuilder().create()
                val list = gson.fromJson(body, JsonObj::class.java)

                runOnUiThread{
                    recycleView.adapter = hInfoAdapter(list)
                }
            }
        })

    }
}