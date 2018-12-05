package com.example.okejon.insideout;

public class VidClip {
    private String judul;
    private String durasi;
    private String videoRawId;

    //array judul video di kategori video
    public static final VidClip[] video = {
            new VidClip("Jangan Menyerah", "04:55", "https://r5---sn-htgx20capjpq-jb3l.googlevideo.com/videoplayback?mime=video%2Fmp4&key=cms1&ei=LAn-W__DBYTCqAHj7r_gBg&expire=1543396748&c=WEB&signature=1DC8883A79B8531E947459F81C5275AFAEEC0EE4.56AC342A1C174E04CBE068B50F71CD7B5BD13541&txp=5431432&ip=47.52.252.199&itag=18&ipbits=0&id=o-AJMQJgvWEhYNVjSSywW5DuZf6krkPhd7y8UGJH6fY-s1&pl=24&source=youtube&requiressl=yes&sparams=clen,dur,ei,expire,gir,id,ip,ipbits,ipbypass,itag,lmt,mime,mip,mm,mn,ms,mv,pcm2cms,pl,ratebypass,requiressl,source&fvip=5&clen=20588550&gir=yes&ratebypass=yes&dur=295.729&lmt=1541862535269138&video_id=dkfxVm34p3Y&title=%5BVIDEO+MOTIVASI%5D+Jangan+Menyerah%2C+Berikan+Yang+Terbaik+%28Subtitle+Indonesia%29&rm=sn-i3bzr76&fexp=23763603&req_id=6462fd966cd2a3ee&ipbypass=yes&mip=158.140.172.39&redirect_counter=2&cm2rm=sn-htgx20capjpq-habe7e&cms_redirect=yes&mm=29&mn=sn-htgx20capjpq-jb3l&ms=rdu&mt=1543385122&mv=m&pcm2cms=yes"),
            new VidClip("Fiersa - Waktu yang Salah", "05:12", "https://r2---sn-htgx20capjpq-jb3l.googlevideo.com/videoplayback?dur=312.981&expire=1543396806&pl=24&gir=yes&ratebypass=yes&itag=18&key=cms1&ipbits=0&signature=6A7E6A8AE9C426B72F6A10F0C56690D5254805B2.4CD246201F185EC1446643D4245896A420538A&source=youtube&c=WEB&clen=22238731&requiressl=yes&mime=video%2Fmp4&fvip=2&lmt=1537136412531159&id=o-ALa_U-csaZG6VYlMkz-t_OPFKEKD_4tY3fJtQHTC-bT6&ei=ZQn-W9X4O5etwwSa4Kb4Dw&sparams=clen,dur,ei,expire,gir,id,ip,ipbits,ipbypass,itag,lmt,mime,mip,mm,mn,ms,mv,pcm2cms,pl,ratebypass,requiressl,source&beids=9466587&ip=191.240.99.142&video_id=XJXKfq26N_w&title=Fiersa+Besari+ft+Tantri+-+Waktu+Yang+Salah++%5Bunofficial+lirik+video%5D&rm=sn-8p5hvj-jo4e7l,sn-bg0de7l&fexp=9466587,23763603&req_id=2506cefcc3eaa3ee&redirect_counter=2&cms_redirect=yes&ipbypass=yes&mip=158.140.172.39&mm=29&mn=sn-htgx20capjpq-jb3l&ms=rdu&mt=1543375878&mv=m&pcm2cms=yes")
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

