package com.example.testhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val squares = generateSquareList().toMutableList()

        val rv:RecyclerView = findViewById(R.id.activity_main__rv)
        val adapter = MainAdapter(squares)
        rv.adapter = adapter
        rv.layoutManager=GridLayoutManager(this, 3)
        //rv.layoutManager = LinearLayoutManager(this)

        val fab: FloatingActionButton = findViewById(R.id.activity_main__fab)
        fab.setOnClickListener{
            squares.add(square(
                (squares.size+1).toString()
            ))
            adapter.notifyDataSetChanged()
        }
    }
    private fun generateSquareList(): List<square> {
        return listOf(
            square("1"),square("2")
        )
    }
}
