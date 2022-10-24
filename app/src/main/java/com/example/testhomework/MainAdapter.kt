package com.example.testhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val squares:List<square>): RecyclerView.Adapter<MainAdapter.MainViewHolder>()
{
    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val num:TextView = itemView.findViewById(R.id.text_id)
        fun bind(sq:square){
            num.text=sq.num
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val temp:Int = squares.size
        return if(temp%2==0) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.square_layout_red, null)
            MainViewHolder(view)
        } else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.square_layout_blue, null)
            MainViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(squares[position])
    }

    override fun getItemCount(): Int {
        return squares.size
    }
}