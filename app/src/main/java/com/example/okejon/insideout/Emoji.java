package com.example.okejon.insideout;

public class Emoji {

    private String tanggal;

    public static final Emoji[] insideout = {
            //tanggal
            new Emoji("23 Oktober 2018"),
            new Emoji("24 Oktober 2018")
    };

    public Emoji(String tanggal){
        this.tanggal = tanggal;
    }

    //aplikasi blm utuh, msh pecah. simpan digalery.
    //tampilan warna
    //


    public String getNama() {
        return tanggal;
    }

    @Override
    public String toString() {
        return this.tanggal;
    }
}
