package com.example.testhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val squares: List<square>
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.square_color, null)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(squares[position])
    }

    override fun getItemCount(): Int {
        return squares.size
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv: TextView = itemView.findViewById(R.id.text_id)
        fun bind(sq: square){
            tv.text = sq.num.toString()
            if (sq.num%2 == 0)
            {
                tv.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.redColor))
            }
            else
            {
                tv.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.blueColor))
            }
        }
    }


}