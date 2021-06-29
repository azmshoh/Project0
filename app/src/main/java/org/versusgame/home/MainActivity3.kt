package org.versusgame.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_natija.*

class MainActivity3 : AppCompatActivity() {
    val adapterStudent : StudentAdapter = StudentAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        recyclerVievle.adapter = adapterStudent
        var uname: ArrayList<Student> = arrayListOf()
        for (i in 0..10000){
            var studen: Student = Student()
            uname.add(studen)
        }
        adapterStudent.model = (uname)

    }
}