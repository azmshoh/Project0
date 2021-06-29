package org.versusgame.home

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_timer_finish.*
var user :ArrayList<User> = arrayListOf()
var oyinchilar =""
class timerFinish : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer_finish)
        intentga()
         }
    //onCreate ichida bajariladigan ishlar
    fun intentga(){
        var maxOchko=0
        var ele=0
        var pe= this.getSharedPreferences("MyShare", MODE_PRIVATE)
        var barJavob = intent.getIntExtra("barchaJavob", 0)
        var togJavob = intent.getIntExtra("togriJavob", 0)
        var ism = intent.getStringExtra("name").toString()
         text12.text = barJavob.toString()
        text22.text = togJavob.toString()
        text32.text = "${barJavob-togJavob}"
        var i=" "
        var peSoni = pe.getInt("soni",0)
        var bb=true
        for (l in 0..peSoni) {
            if (pe.getString("${"name" + l}", "").equals(ism)) {
                if (pe.getInt("${"ochko" + l}",0)<togJavob){
                   pe.edit().putInt("${"ochko" + l}",togJavob).apply()

                }
                i = " Siz "
                bb=false
            }
        }
        if(bb){
            peSoni++
            pe.edit().putInt("soni" , peSoni).apply()
            pe.edit().putString("${"name" + peSoni}", ism).apply()
            pe.edit().putInt("${"ochko" + peSoni}",togJavob).apply()
            var use : User= User()
            use.title=ism
            use.ochko =togJavob
            user.add(use)
        }
        oyinchilar=""
        for (l in 1..peSoni){
            oyinchilar = oyinchilar+pe.getString("${"name" + l}","")+" - "+pe.getInt("${"ochko"+l}",0)+"\n"
            if (maxOchko < pe.getInt("${"ochko"+l}",0)){
                maxOchko= pe.getInt("${"ochko"+l}",0)
                ele=l
            }
        }


         if (togJavob>=maxOchko){
             if (pe.getString("${"name"+ele}","").equals(ism)){
                WinElseNot.text= "Recordingiz yangilandi!"
            }
            else{
                WinElseNot.text= "Siz yangi record o'rnatdizgiz!!"
            }
        }
        else{
            WinElseNot.text= "Qayta urinib ko'ring!"
        }
        nameTime.text = "${"Record:"+i+pe.getString("${"name" + ele}","") }"+" "+ pe.getInt("${"ochko"+ele}",0)
        sizNameTime.text = "${"Siz: "+togJavob}"
        buttonTime1.setOnClickListener {
            var inte =Intent(this,MainActivity::class.java)
            inte.putExtra("vaqt",intent.getLongExtra("time",14))
            inte.putExtra("n1me",ism)
            startActivity(inte)
            finish()
        }
        buttonTime2.setOnClickListener {
            var inte =Intent(this,NatijaActivity::class.java)
            inte.putExtra("oyinchilar", oyinchilar)
            startActivity(inte)

        }

    }


}