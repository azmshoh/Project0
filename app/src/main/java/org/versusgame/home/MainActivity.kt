package org.versusgame.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    var dd =
        arrayListOf<Int>(-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    lateinit var botton: ArrayList<Button>
    var stAmal = arrayListOf<String>("+", "-", "*", "/")
    var san11 = 0
    var san12 = 0
    var ochko = 0
    var togriJavob = 0
    var barchaJavoblar = 0
    var barFoiz: Long = 0
    lateinit var timeActivit: Intent
    var vaqtS by Delegates.notNull<Long>()
    var name by Delegates.notNull<String>()
    lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botton = arrayListOf(bottom1, bottom2, bottom3, bottom4)
        vaqtS = intent.getLongExtra("vaqt", 15)
        name = intent.getStringExtra("n1me").toString()
        loginName.text= name
        barFoiz = vaqtS
        Asosiy()
        timeActivit = Intent(this, timerFinish::class.java)
        timer = object : CountDownTimer(vaqtS * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                progressBar.progress = (barFoiz * 1.0 / (vaqtS * 1.0 / 100.0)).toInt()
                --barFoiz
                timersani1.text = barFoiz.toString()
            }

            override fun onFinish() {
                nol()
            }
        }
        timer.start()
    }

    //sonlarga qiymat berish
    fun sonRandm(ss: TextView): Int {
        ss.text = Random.nextInt(1, 10).toString()
        return ss.text.toString().toInt()
    }

    fun setSonlar() {
        san11 = sonRandm(san1)
        san12 = sonRandm(san2)

    }

    // amalni tanlash va qoyish
    fun selectAmal(): String {
        var ss = stAmal[0]
        amal.text = ss
        return ss
    }

    // togri javobni olish
    fun sonn(s: String): Int {
        var n = san11 + san12
        when (s) {
            "-" -> {
                n = san11 - san12
            }
            "*" -> {
                n = san11 * san12
            }
            "/" -> {
                var j = Random.nextInt(1, 10)
                san11 = san12 * j
                san1.text = san11.toString()
                n = j
            }
        }
        return n
    }

    //Asosiy vazifani bajarish
    fun Asosiy() {
        dd.shuffle()
        botton.shuffle()
        stAmal.shuffle()
        setSonlar()
        var javob = sonn(selectAmal())
        (botton[0]).text = javob.toString()
        (botton[1]).text = (javob + dd[1]).toString()
        (botton[2]).text = (javob + dd[2]).toString()
        (botton[3]).text = (javob + dd[3]).toString()
    }

    //javobni tekshirish
    fun trueFalse(bot: View) {
        if (botton[0] == bot) {
            ochko++
            togriJavob++
        } else {
            ochko--
        }
        barchaJavoblar++
        soni1.text = ochko.toString()
        Asosiy()
    }

    //timer clas tugagach ishlaydigan vazifalar
    fun nol() {
        timeActivit.putExtra("name", name)
        timeActivit.putExtra("time",vaqtS)
        timeActivit.putExtra("togriJavob", togriJavob)
        timeActivit.putExtra("barchaJavob", barchaJavoblar)
        startActivity(timeActivit)
        progressBar.progress = 100
        barchaJavoblar = 0
        togriJavob = 0
        ochko = 0
        timersani1.text = vaqtS.toString()
        soni1.text = "0"
        finish()
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }


}