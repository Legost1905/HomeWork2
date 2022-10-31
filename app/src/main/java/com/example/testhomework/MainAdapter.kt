package com.example.testhomework

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val squares:List<square>): RecyclerView.Adapter<MainAdapter.MainViewHolder>()
{
    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val num:TextView = itemView.findViewById(R.id.text_id)
        private val cs:ConstraintLayout = itemView.findViewById(R.id.cs_1)


        fun bind(sq:square){
            num.text=sq.num
            if(sq.num.toInt()%2==0){
                cs.setBackgroundColor(ContextCompat.getColor(cs.context, R.color.redColor))
            }
            else{
                cs.setBackgroundColor(ContextCompat.getColor(cs.context, R.color.blueColor))
            }
        }
    }

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
}