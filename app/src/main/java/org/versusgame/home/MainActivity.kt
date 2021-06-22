package org.versusgame.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var savol1 = 10
    var savol2 = 1
    var ranSum = 50
    var tJ=0.0
    var inSozi =""
    var end = 25
    var startzero=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginName.text = intent.getStringExtra("n1me").toString()
         inSozi =intent.getStringExtra("sozi").toString()
            tJ = repall()
            asosiy()
    }

    //random orqali son tanlash
    fun ran(a: Int, b: Int): Int {
        return Random.nextInt(a, b)
    }
    var levelSum=1
    var wrep =120
    var ret =50

    //levellarni saralash
    fun startlevel() {
        if (inSozi.equals("oson")){
            wrep=50
            ret =50
            end=10
            ranSum=20
            startzero =1
        }
        else if (inSozi.equals("orta")){
            wrep=100
            ret =50
            end =20
            ranSum=50
            startzero=20
        }
        else if (inSozi.equals("qiyin")){
            wrep=200
            ret =250
            end =100
            ranSum= 150
            startzero=50
        }
    }
    var gg =true
    //levelning glavni yeri
    fun levelRep(sani : Int){
       if (gg) {
           startlevel()
           gg=false
       }
        if(wrep<=sani){
            levelSum++
            levelSoni.text= levelSum.toString()
            wrep+=ret
            ret+=end
        }
    }
    //san1 san2 amal ga qiymat beradi
    fun repall(): Double {
        var d = "+"
        var a = ran(0, 4)
        when (a) {
            0 -> d = "+"
            1 -> d = "-"
            2 -> d = "*"
            3 -> d = "/"
        }
        var array = arrayListOf<Int>()
        var index =0
        //nicha odimdan yurishi
        if (inSozi.equals("oson")){
            ranSum+=2
        }
        else if (inSozi.equals("orta")){
            ranSum+=4
        }
        else if (inSozi.equals("qiyin")){
            ranSum+=10
        }
        savol1 = ran(startzero, ranSum)
        levelRep(ranSum)
        for (i in 1..savol1){
            if (savol1%i==0){
                array.add(index,i)
                index++
            }
            var ele= ran(0,index)
        savol2= array[ele]


        }
        var gl = 0.0
        if (d.equals("+")) {
            gl = savol1 + savol2 * 1.0
        } else if (d.equals("-")) {
            gl = savol1 - savol2 * 1.0
        } else if (d.equals("*")) {
            gl = savol1 * savol2 * 1.0
        } else if (d.equals("/")) {
            gl = savol1 * 1.0 / savol2 * 1.0
        }
        san1.text = savol1.toString()
        san2.text = savol2.toString()
        amal.text = d
        return gl
    }

    //togri va notogri javoblarni qoyip beradi
    fun asosiy() {
        var javob1 = 0.0
        var javob2 = 0.0
        var javob3 = 0.0
        var javob4 = 0.0
        var reples = ran(5, 9)
        when (reples) {
            5 -> {
                javob1 = tJ
                javob2 = javob1 - ran(1, 6)
                javob3 = javob1 + ran(1, 4)
                javob4 = javob1 + ran(4, 7)
            }
            6 -> {
                javob2 = tJ
                javob1 = javob2 - ran(1, 6)
                javob4 = javob2 + ran(1, 4)
                javob3 = javob2 + ran(4, 7)
            }
            7 -> {
                javob3 = tJ
                javob4 = javob3 - ran(1, 6)
                javob2 = javob3 + ran(1, 4)
                javob1 = javob3 + ran(4, 7)
            }
            else -> {
                javob4 = tJ
                javob3 = javob4 - ran(1, 6)
                javob1 = javob4 + ran(1, 4)
                javob2 = javob4 + ran(4, 7)
            }
        }
        bottom1.text = cons(javob1.toString())
        bottom2.text = cons(javob2.toString())
        bottom3.text = cons(javob3.toString())
        bottom4.text = cons(javob4.toString())
    }
    //.0ni olip tashlidi
    fun cons(soz: String): String {
        var s: String = ""
        if (soz.endsWith(".0")) {
            s = soz.substring(0, soz.length - 2)
        } else {
            s = soz
        }
        return s
    }

    //tre fols tekshiradi
    fun trueFalse(son: Double): Boolean {
        return tJ == son
    }

    //togri bolsa hato bolsa ochko yozadi
     var soni =0
    fun aktiv(uu: Boolean) {

        if(uu){
          soni++
        }else{
            soni--
        }
        soni1.text= soni.toString()

    }

    //bottonlardagi teksga tekshiradi
    fun onClikBotton(it: View) {
        when (it) {
            bottom1 -> {
                aktiv(trueFalse(bottom1.text.toString().toDouble()))
                onRestart()
            }
            bottom2 -> {
                aktiv(trueFalse(bottom2.text.toString().toDouble()))
                onRestart()
            }
            bottom3 -> {
                aktiv(trueFalse(bottom3.text.toString().toDouble()))
                onRestart()
            }
            bottom4 -> {
                aktiv(trueFalse(bottom4.text.toString().toDouble()))
                onRestart()
            }
        }
    }
    override fun onRestart() {
        tJ = repall()
        asosiy()
        super.onRestart()
    }


}