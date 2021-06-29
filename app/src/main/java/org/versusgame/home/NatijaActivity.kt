package org.versusgame.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_natija.*

val adapter: ListAdapter = ListAdapter()
class NatijaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_natija)
        recyclerViev.adapter = adapter
        recyclerViev.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        setData()
    }

    fun setData() {
        var use: ArrayList<User> = arrayListOf()
        var pe = this.getSharedPreferences("MyShare", MODE_PRIVATE)
        var peSoni = pe.getInt("soni", 0)
        for (l in 1..peSoni) {
            var user: User = User()
            user.title = pe.getString("${"name" + l}", "")!!
            user.ochko = pe.getInt("${"ochko" + l}", 0)
            use.add(user)
        }

        for (i in 0..peSoni-1) {
            for (l in i..peSoni-1) {
                if (use[i].ochko < use[l].ochko) {
                    var t = use[i].title
                    var o = use[i].ochko
                    use[i].title = use[l].title
                    use[i].ochko = use[l].ochko
                    use[l].title = t
                    use[l].ochko = o
                }
            }
        }
        adapter.setData(use)
    }

}