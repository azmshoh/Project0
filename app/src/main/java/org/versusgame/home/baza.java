package org.versusgame.home;

import android.content.Context;
import android.content.SharedPreferences;

import org.jetbrains.annotations.NotNull;

public class baza  {
    protected Context context;
    protected SharedPreferences pr;
    protected String Jname;
    protected int Jscore;
    public baza(@NotNull Context context){
        this.context = context;
        pr =context.getSharedPreferences("MyPeref",0);
    }

    public String getJname() {
        return Jname=pr.getString("Jname","");
    }

    public void setJname(String jname) {
        pr.edit().putString("Jname",jname).apply();
        Jname =jname;
    }

    public int getJscore() {
        return Jscore=pr.getInt("Jscore",Jscore);
    }

    public void setJscore(int jscore) {
        pr.edit().putInt("Jscore",jscore).apply();
        Jscore= jscore;
    }

}
