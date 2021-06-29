package org.versusgame.home

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    private var tvTitle: TextView =itemView.tvTitle
    private var tvOchko : TextView= itemView.tvOchko

    fun populetModel(user : User){
        tvTitle.text =user.title
        tvOchko.text = user.ochko.toString()
    }
}