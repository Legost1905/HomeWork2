package com.example.testhomework.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testhomework.MainAdapter
import com.example.testhomework.R
import com.example.testhomework.square


fun createStartFragment(
    field: String
): StartFragment {
    return StartFragment().apply {
        arguments = Bundle().apply { putString("key", field) }
    }
}

class StartFragment : Fragment() {

    private var buf_size = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.start_fragment, null, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val squares = mutableListOf<square>()

        if (savedInstanceState != null) {
            buf_size = savedInstanceState.getInt("counter", -1)
            generateSquareList(buf_size-1, squares)
        }

        val rv: RecyclerView = view.findViewById(R.id.activity_main__rv)
        val adapter = MainAdapter(squares)
        rv.adapter = adapter
        var columns :Int? = null
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            columns = 3
        }
        else
        {
            columns = 4
        }
        rv.layoutManager = GridLayoutManager(view.context, columns)

        val but: Button = view.findViewById(R.id.activity_main__button)
        but.setOnClickListener{
            squares.add( square(buf_size))
            adapter.notifyDataSetChanged()
            buf_size = squares.size
        }



    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", buf_size)
    }


    private fun generateSquareList(buf:Int, squares: MutableList<square> ) {
        for(i in 0..buf)
            squares.add(square(i))
    }
}