package org.versusgame.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main3.view.*
import kotlinx.android.synthetic.main.recylee.view.*

class recyleHolder(itemView : View): RecyclerView.ViewHolder(itemView)  {
    var item : RecyclerView = itemView.recyHori
    fun setModelRecyle(recy : recycle){
        item =recy.model11
    }
}