package org.versusgame.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class recyleAdapter : RecyclerView.Adapter<recyleHolder>() {
    var modells: List<recycle> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recyleHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.recylee, parent, false)
        return recyleHolder(view)
    }

    override fun onBindViewHolder(holder: recyleHolder, position: Int) {
        holder.setModelRecyle(modells[position])
    }

    override fun getItemCount(): Int {
      return modells.size
    }
}