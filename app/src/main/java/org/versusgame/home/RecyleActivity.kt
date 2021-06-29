package org.versusgame.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_recyle.*

class RecyleActivity : AppCompatActivity() {
    val adapterRecyle: recyleAdapter = recyleAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyle)
        recyleActiviyre.adapter = adapterRecyle
        var modell: ArrayList<recycle> = arrayListOf()
        for (l in 0..100) {
            var uname: ArrayList<Student> = arrayListOf()
            for (i in 0..100) {
                var studen: Student = Student()
                uname.add(studen)
            }
            var ss = recycle(recyori)
            ss.setRecyle(uname)
            modell.add(ss)
        }
        adapterRecyle.modells = modell


    }
}