package org.versusgame.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {
    var trueFalse: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        trueFalse = intent.getBooleanExtra("truefalse", false)
        if (trueFalse){
            imageview1.text ="To'gri"
        }else{
            imageview1.text = "Noto'gri"
        }
    }
}