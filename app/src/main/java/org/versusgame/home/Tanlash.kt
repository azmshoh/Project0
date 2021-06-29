package org.versusgame.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tanlash.*

class Tanlash : AppCompatActivity() {
    var aktiv = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanlash)
        var nn= Intent(this,RecyleActivity::class.java)
        startActivity(nn)
    }

    fun onClikBontton(it: View) {
        var intent2 = Intent(this, name::class.java)
        when (it) {
            sonAktiv2 -> {
                aktiv = "san2xona"
            }
            sonAktiv3 -> {
                aktiv = "san3xona"
            }
        }
        intent2.putExtra("ayna",aktiv)
        startActivity(intent2)
    }
}