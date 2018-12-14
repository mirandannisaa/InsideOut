package com.example.okejon.insideout;

public class Emoji {

    private String tanggal;

    public static final Emoji[] insideout = {
            //tanggal
            new Emoji("10 Desember 2018"),
            new Emoji("11 Desember 2018"),
            new Emoji("12 Desember 2018"),
            new Emoji("13 Desember 2018"),
            new Emoji("14 Desember 2018")
    };

    public Emoji(String tanggal){
        this.tanggal = tanggal;
    }



    public String getNama() {
        return tanggal;
    }

    @Override
    public String toString() {
        return this.tanggal;
    }
}
