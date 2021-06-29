package org.versusgame.home

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class StudentHolder(itemViev: View) : RecyclerView.ViewHolder(itemViev) {
    var ati : TextView = itemViev.tvTitle
    var fam : TextView = itemViev.tvOchko
    fun setModel(student: Student){
        ati.text= student.ati
        fam.text = student.fam
    }
}