package org.versusgame.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_name.*


class name : AppCompatActivity() {
    var ayna =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
       ayna = intent.getStringExtra("ayna").toString()

    }
    fun onClikBotton2(it: View){
        when(ayna){
            "san2xona"->{
                if ((name.text.toString()).isEmpty() || name.text.toString().length < 2) {
                    name.error = "Login bo'sh qolmasligi kerak va 1xonadan katta bo'lishi lozim"
                } else if (name.text.toString().length <= 15) {
                    var intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("n1me", name.text.toString())
                    var sozi = ""
                    when (it) {
                        play1 -> {
                            sozi = play1.text.toString()
                        }
                        play2 -> {
                            sozi = "orta"
                        }
                        play3 -> {
                            sozi = play3.text.toString()
                        }
                    }
                    intent.putExtra("sozi", sozi)
                    startActivity(intent)
                } else {
                    name.error = "Login 15 harfdan oshmasligi kerak"
                }
            }
            "san3xona"->{
                if ((name.text.toString()).isEmpty() || name.text.toString().length < 2) {
                    name.error = "Login bo'sh qolmasligi kerak va 1xonadan katta bo'lishi lozim"
                } else if (name.text.toString().length <= 15) {
                    var intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("n1me", name.text.toString())
                    startActivity(intent)
                } else {
                    name.error = "Login 15 harfdan oshmasligi kerak"
                }
            }
        }
    }
}