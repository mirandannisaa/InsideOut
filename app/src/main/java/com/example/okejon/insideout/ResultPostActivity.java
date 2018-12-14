package com.example.okejon.insideout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultPostActivity extends AppCompatActivity {

    TextView txtCurhat, txtTanggal, txtLoc;
    Button videoButton;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_post);

        videoButton = (Button)findViewById(R.id.btnvideo);
        backButton = (Button)findViewById(R.id.btnback);

        Intent inte = getIntent();

        Bitmap gbr = (Bitmap) inte.getParcelableExtra("idfoto");
        ImageView var = (ImageView) findViewById(R.id.idFotoresult);
        var.setImageBitmap(gbr);

        txtTanggal = (TextView)findViewById(R.id.textTanggalact);
        Bundle bundle2=getIntent().getExtras();
        String showTanggal=bundle2.getString("textTanggal");
        txtTanggal.setText(showTanggal);

        txtCurhat = (TextView)findViewById(R.id.textCurhatact);
        Bundle bundle=getIntent().getExtras();
        String showText=bundle.getString("mytext");
        txtCurhat.setText(showText);

        txtLoc = (TextView)findViewById(R.id.textLocationact);
        Bundle bundle3=getIntent().getExtras();
        String showLoc=bundle.getString("locationku");
        txtLoc.setText(showLoc);

        videoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ResultPostActivity.this, MediaPlayback.class);
                startActivity(intent);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent inte = new Intent(ResultPostActivity.this, MainActivity.class);
                startActivity(inte);
            }
        });

    }
}
