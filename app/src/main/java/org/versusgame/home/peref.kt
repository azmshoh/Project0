package org.versusgame.home

import android.content.Context

class peref(private val context: Context) {
    private val prefs = context.getSharedPreferences("Myperef", 0)
    var name: String
        set(value) {
            prefs.edit().putString("name", value).apply()
        }
        get() {
            return prefs.getString("name", "")!!
        }
    var score: Int
        get() {
            return prefs.getInt("score", 0)
        }
        set(value) {
            prefs.edit().putInt("score", value).apply()
        }


}