package org.versusgame.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ListAdapter:RecyclerView.Adapter<ListViewHolder>() {
    var models:  List<User> = listOf()

    fun setData(data: ArrayList<User>){
        this.models = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.populetModel(models[position])
    }

    override fun getItemCount(): Int {
        return  models.size
    }
}