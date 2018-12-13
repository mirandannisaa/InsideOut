package com.example.okejon.insideout;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class MediaPlayback extends AppCompatActivity {

    VideoView videoView;
    ListView listView;
    TextView textLoading;

    ArrayList<String> listVideo;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_playback);

        videoView = (VideoView) findViewById(R.id.videoView);
        listView = (ListView) findViewById(R.id.listView);

        listVideo = new ArrayList<>();
        listVideo.add("Video Motivasi Persahabatan");
        listVideo.add("Video Motivasi Terbaik");
        listVideo.add("Video Motivasi Jangan Menyerah");

        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listVideo);
        //adapter ambil data class vidclip
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, VidClip.video);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position){
//                    case 0 :
//                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.j));
//                        break;
//
//                    case 1 :
//                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.f));
//                        break;
//                }
//
//                //controller untuk playback
//                videoView.setMediaController(new MediaController(MainActivity.this));
//
//                videoView.requestFocus();
//                videoView.start();

                //panggil method
                VidClip vidClip = VidClip.video[(int) id];

                Uri vidUri = getMedia(vidClip.getVideoRawId());
                makePlayer(vidUri);
            }
        });
    }

    //load dinamis file media dr class vidclip
    private Uri getMedia(String medName){
        //return Uri.parse("android.resource://" +getPackageName() + "/raw/" +medName);
        if (URLUtil.isValidUrl(medName)){
            //media name dari external URL
            return Uri.parse(medName);
        } else {
            //media name dari resource raw
            return Uri.parse("android.resource://" + getPackageName() + "/raw/" + medName);
        }
    }

    //method dinamis
    private void makePlayer(Uri vidUri){
        //resource video
        videoView.setVideoURI(vidUri);

        //controller untuk playback
        //videoView.setMediaController(new MediaController(MainActivity.this));

//        videoView.requestFocus();
//        videoView.start();

        MediaController medcon = new MediaController(MediaPlayback.this);
        videoView.setMediaController(medcon);
        medcon.setAnchorView(videoView);

        //listener untuk event onPrepared() event dijalankan saat siap dimainkan
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //start mainkan video
                videoView.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MediaPlayback.this, "The End", Toast.LENGTH_SHORT).show();
                //kembalikan ke posisi frame 0
                videoView.seekTo(0);
            }
        });
    }
}