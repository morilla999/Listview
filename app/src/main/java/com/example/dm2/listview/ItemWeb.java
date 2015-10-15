package com.example.dm2.listview;

import android.graphics.drawable.Drawable;

/**
 * Created by dm2 on 13/10/2015.
 */
public class ItemWeb {
    private String titulo;
    private String enlace;
    private int logo;

    public ItemWeb(String tit, String enl, int log){
        titulo = tit;
        enlace = enl;
        logo = log;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getEnlace(){
        return enlace;
    }

    public int getLogo() {
        return logo;
    }
}
