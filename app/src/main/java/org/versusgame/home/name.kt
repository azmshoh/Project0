package org.versusgame.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_name.*

class name : AppCompatActivity() {
    var ayna = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        ayna = intent.getStringExtra("ayna").toString()
        play.setOnClickListener {
            when (ayna) {
                "san2xona" -> {
                    if ((name.text.toString()).isEmpty() || name.text.toString().length < 2) {
                        name.error = "Login bo'sh qolmasligi kerak va 1xonadan katta bo'lishi lozim"
                    } else if (vaqt.text.toString().isEmpty() || vaqt.text.toString()
                            .toLong() <= 10
                    ) {
                        vaqt.error = "10 sekuntdan katta bo'lgan vaqt kiritish lozim"
                    } else if (name.text.toString().length <= 15) {
                        var inten = Intent(this, MainActivity::class.java)
                        inten.putExtra("n1me", name.text.toString())
                        inten.putExtra("vaqt", vaqt.text.toString().toLong())
                        startActivity(inten)
                        finish()
                    } else {
                        name.error = "Login 15 harfdan oshmasligi kerak"
                    }
                }
                "san3xona" -> {
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


}