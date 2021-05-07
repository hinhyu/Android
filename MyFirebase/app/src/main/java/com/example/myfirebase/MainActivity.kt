package com.example.myfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter:MovieCommentAdapter
    private lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.setReverseLayout(true)
        layoutManager.setStackFromEnd(true)
        recycleView.layoutManager = layoutManager

        adapter = MovieCommentAdapter()
        adapter.items.add(MovieComment("0","sky2****", "1분전", 5, "정말 스릴 넘치는 영화였어요. 한 번 더 보고 싶은 영화!!!", 5 ))
        adapter.items.add(MovieComment("0","sdfe3****", "3분전", 4, "good", 4 ))
        adapter.items.add(MovieComment("0","ytrf4****", "12분전", 3, "sososososososo", 3 ))

        recycleView.adapter = adapter

        databaseRef = FirebaseDatabase.getInstance().reference

        saveButton.setOnClickListener{
            val author = input1.text.toString()
            val rating = ratingBar.rating.toLong()
            val contents = input2.text.toString()
            val recommendCount = 0L

            saveComment(author, rating, contents, recommendCount)
        }
    }
    fun saveComment(author:String, rating:Long, contents:String, recommendCount:Long){
        var key : String? = databaseRef.child("comments").push().getKey()
        val comment = MovieComment(key!!, author, "", rating, contents, recommendCount)
        val commentValues : HashMap<String, Any> = comment.toMap()
        commentValues["timestamp"] = ServerValue.TIMESTAMP
        val childUpdates: MutableMap<String, Any> = HashMap()
        childUpdates["/comments/$key"] = commentValues
        databaseRef.updateChildren(childUpdates)
    }
}