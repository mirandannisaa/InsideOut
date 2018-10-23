package com.example.okejon.insideout;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.example.okejon.insideout.MyFirebaseIdService;

public class MainActivity extends AppCompatActivity implements EmojiListFragment.Listener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFirebaseIdService inside = new MyFirebaseIdService();
        inside.showToken();
    }



    public void itemClicked(long id) {
        View fragmentDetail = findViewById(R.id.detailingFrag);
        if(fragmentDetail!=null){
            DetailEmojiFragment deta = new DetailEmojiFragment();
            FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
            deta.setEmoji(id);
            fragTrans.replace(R.id.detailingFrag,deta);
            fragTrans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragTrans.addToBackStack(null);
            fragTrans.commit();
        }else{
            Toast.makeText(this, "Item " + id + " was clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this.getApplicationContext(), DetailActivity.class);
            Bundle b = new Bundle();
            b.putDouble("id",id);
            intent.putExtras(b);
            startActivity(intent);
        }
    }
}