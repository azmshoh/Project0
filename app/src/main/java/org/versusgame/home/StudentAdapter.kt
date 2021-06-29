package org.versusgame.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter : RecyclerView.Adapter<StudentHolder>() {
    var model: List<Student> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return StudentHolder(view)
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        holder.setModel(model[position])
    }

    override fun getItemCount(): Int {
        return model.size
    }
}