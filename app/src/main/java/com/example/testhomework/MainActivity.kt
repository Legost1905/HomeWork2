package com.example.testhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv:RecyclerView = findViewById(R.id.activity_main__rv)
        val adapter = MainAdapter(generateNumbersList())
        rv.adapter = adapter
        rv.layoutManager=LinearLayoutManager(this)
    }

    private fun generateNumbersList(): List<square> {
        return listOf(
            square("1"),square("2"),square("3")
        )
    }
}
