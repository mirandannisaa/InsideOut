package com.example.okejon.insideout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultPostActivity extends AppCompatActivity {

    TextView txtCurhat, txtTanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_post);

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

    }
}
