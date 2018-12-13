package com.example.okejon.insideout;

public class VidClip {
    private String judul;
    private String durasi;
    private String videoRawId;

    //array judul video di kategori video
    public static final VidClip[] video = {
            new VidClip("Video Motivasi Persahabatan", "03:52", "persahabatan"),
            new VidClip("Video Motivasi Terbaik", "03:36", "terbaik"),
            new VidClip("Video Motivasi Jangan Menyerah", "03:09", "animasi")
    };

    //setiap data ada judul, durasi, gambar
    public VidClip(String judul, String durasi, String videoRawId) {
        this.judul = judul;
        this.durasi = durasi;
        this.videoRawId = videoRawId;
    }

    public String getJudul(){
        return judul;
    }

    public String getDurasi(){
        return durasi;
    }

    public String getVideoRawId(){
        return videoRawId;
    }

    public String toString(){
        return this.judul;
    }
}

