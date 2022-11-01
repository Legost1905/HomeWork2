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
import com.example.testhomework.DataTables
import com.example.testhomework.MainAdapter
import com.example.testhomework.R


fun createFirstFragment(
    field: String
): FirstFragment {
    return FirstFragment().apply {
        arguments = Bundle().apply { putString("key", field) }
    }
}

class FirstFragment : Fragment() {

    private var cnt = 0



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_fragment, null, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tables = mutableListOf<DataTables>()

        if (savedInstanceState != null) {
            cnt = savedInstanceState.getInt("counter", 0)
            generateTableList(cnt-1, tables)
        }

        val rv: RecyclerView = view.findViewById(R.id.activity_main__rv)
        val adapter = MainAdapter(tables)
        rv.adapter = adapter
        var spanCnt :Int? = null
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            spanCnt = 3
        }
        else
        {
            spanCnt = 4
        }
        rv.layoutManager = GridLayoutManager(view.context, spanCnt)

        val but: Button = view.findViewById(R.id.activity_main__button)
        but.setOnClickListener{
            tables.add( DataTables(
                cnt
            )
            )
            adapter.notifyDataSetChanged()
            cnt = tables.size
        }



    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", cnt)
    }



    private fun generateTableList(cnt1:Int, tables: MutableList<DataTables> ) {
        for(j in 0..cnt1)
        {
            tables.add(DataTables(j))
        }
    }
}