package com.example.okejon.insideout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    private Button diaryButton;
    private Button videoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        diaryButton = (Button)findViewById(R.id.btndiary);
        videoButton = (Button)findViewById(R.id.btnvideo);

        diaryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent inte = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(inte);
            }
        });

        videoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(FirstActivity.this, MediaPlayback.class);
                startActivity(intent);
            }
        });
    }
}
