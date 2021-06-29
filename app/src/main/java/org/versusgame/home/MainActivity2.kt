package org.versusgame.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    var tJ = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        loginName2.text = intent.getStringExtra("n1me")
        tJ = repall()
        asosiy()
    }

    //random orqali son tanlash
    fun ran(a: Int, b: Int): Int {
        return Random.nextInt(a, b)
    }

    //san1 san2 sa3ga  amalga qiymat beradi
    fun repall(): Int {
        //birinchi amalni tanlab beradi
        var d1 = "+"
        var a1 = ran(0, 3)
        when (a1) {
            0 -> d1 = "+"
            1 -> d1 = "-"
            2 -> d1 = "*"
        }
        var savol21 = ran(1, 20)
        var savol22 = ran(1, 20)
        var savol32 = ran(1, 20)
        var gl = 0
        //birinchi 2son yigindisi
        if (d1.equals("+")) {
            gl = savol21 + savol22
        } else if (d1.equals("-")) {
            gl = savol21 - savol22
        } else if (d1.equals("*")) {
            gl = savol21 * savol22
        }
        //ikkinchi amalni tanlab beradi
        var d2 = "+"
        var a2 = ran(0, 3)
        when (a2) {
            0 -> d2 = "+"
            1 -> d2 = "-"
            2 -> d2 = "*"
        }
        if (d2.equals("+")) {
            gl += savol32
        } else if (d2.equals("-")) {
            gl -= savol32
        } else if (d2.equals("*")) {
            if (d1.equals("*")) {
                gl *= savol32
            } else {
                if (d1.equals("+")) {
                    gl = (savol22 * savol32) + savol21
                } else if (d1.equals("-")) {
                    gl = savol21 - (savol32 * savol22)
                }
            }
        }
        san21.text = savol21.toString()
        san22.text = savol22.toString()
        san23.text = savol32.toString()
        amal21.text = d1
        amal22.text = d2
        return gl
    }

    //togri va notogri javoblarni qoyip beradi
    fun asosiy() {
        var javob21 = 0
        var javob22 = 0
        var javob23 = 0
        var javob24 = 0
        var reples = ran(5, 9)
        when (reples) {
            5 -> {
                javob21 = tJ
                javob22 = javob21 - ran(1, 6)
                javob23 = javob21 + ran(1, 4)
                javob24 = javob21 + ran(4, 7)
            }
            6 -> {
                javob22 = tJ
                javob21 = javob22 - ran(1, 6)
                javob24 = javob22 + ran(1, 4)
                javob23 = javob22 + ran(4, 7)
            }
            7 -> {
                javob23 = tJ
                javob24 = javob23 - ran(1, 6)
                javob22 = javob23 + ran(1, 4)
                javob21 = javob23 + ran(4, 7)
            }
            else -> {
                javob24 = tJ
                javob23 = javob24 - ran(1, 6)
                javob21 = javob24 + ran(1, 4)
                javob22 = javob24 + ran(4, 7)
            }
        }
        bottom221.text = javob21.toString()
        bottom222.text = javob22.toString()
        bottom223.text = javob23.toString()
        bottom224.text = javob24.toString()
    }

    //tre fols tekshiradi
    fun trueFalse(son: Int): Boolean {
        return tJ == son
    }

    //bottonlardagi teksga tekshiradi
    fun on02(it: View) {
        when (it) {
            bottom221 -> {
                aktiv(trueFalse(bottom221.text.toString().toInt()))
                onResume()
            }
            bottom222 -> {
                aktiv(trueFalse(bottom222.text.toString().toInt()))
                onResume()
            }
            bottom223 -> {
                aktiv(trueFalse(bottom223.text.toString().toInt()))
                onResume()
            }
            bottom224 -> {
                aktiv(trueFalse(bottom224.text.toString().toInt()))
                onResume()
            }
        }
    }

    //togri bolsa hato bolsa ochko yozadi
    var soni = 0
    fun aktiv(uu: Boolean) {
        if (uu) {
            soni++
        } else {
            soni--
        }
        soni12.text = soni.toString()
    }

    override fun onResume() {
        super.onResume()
        loginName2.text = intent.getStringExtra("n1me")
        tJ = repall()
        asosiy()
    }

    override fun onRestart() {
        loginName2.text = intent.getStringExtra("n1me")
        tJ = repall()
        asosiy()
        super.onRestart()
    }
}