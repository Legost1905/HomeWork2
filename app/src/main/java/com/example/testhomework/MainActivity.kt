package com.example.testhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testhomework.fragment.createStartFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val trasaction = supportFragmentManager.beginTransaction()
            trasaction.add(R.id.container, createStartFragment("Hello"))
            trasaction.commit()
        }
    }
}
