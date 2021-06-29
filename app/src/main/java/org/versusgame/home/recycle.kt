package org.versusgame.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recylee.view.*

class recycle(Recy : RecyclerView) {
     var model11: RecyclerView = Recy
    fun setRecyle(uname: ArrayList<Student>){
        val adpterStudent : StudentAdapter = StudentAdapter()
        model11.adapter=adpterStudent
       adpterStudent.model= uname
    }

}