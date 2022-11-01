package com.example.testhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val tables: List<DataTables>
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_tables, null)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(tables[position])
    }

    override fun getItemCount(): Int {
        return tables.size
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv: TextView = itemView.findViewById(R.id.view_table)
        fun bind(table: DataTables){
            tv.text = table.number.toString()
            if (table.number % 2 == 0)
            {
                tv.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.red))
            }
            else
            {
                tv.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.blue))
            }
        }
    }


}