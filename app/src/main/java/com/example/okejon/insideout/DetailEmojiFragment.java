package com.example.okejon.insideout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */

public class DetailEmojiFragment extends Fragment {

    private long emojiId;
    ImageView imageView;
    EditText editText;
    //variabel foto untuk foto awal, fotohasil untuk foto setelah diemoji
    Bitmap foto, fotohasil ;
    public static TextView location;

    public DetailEmojiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myFragmentView = inflater.inflate(R.layout.fragment_detail_emoji, container, false);

        View v = getView();


        Button btnloc =(Button)myFragmentView.findViewById(R.id.buttonLoc);
        btnloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(getContext(), LocationActivity.class);
                startActivity(inte);
            }
        });
        //button camera
            Button btn = (Button) myFragmentView.findViewById(R.id.button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //intent camera
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 0);
                }
            });

            //textbox curhat
            final EditText editText = (EditText) myFragmentView.findViewById(R.id.editText);
            final EditText editText1 = (EditText)myFragmentView.findViewById(R.id.txtTgl);
            location = (TextView)myFragmentView.findViewById(R.id.tvLoc);

            //memanggil kls emoji krn ambil tanggal untuk list fragment
            //final TextView tittle = (TextView) myFragmentView.findViewById(R.id.txtTgl);
            Emoji emoji = Emoji.insideout[(int) emojiId];
            editText1.setText(emoji.getNama());

            Bundle bundle = getActivity().getIntent().getExtras();
            //String showLoc = bundle.getString("locationku");
            //tvLoc.setText(showLoc);

            imageView = (ImageView) myFragmentView.findViewById(R.id.hasil);

            //button kirim ke activity
            Button btn2 = (Button)myFragmentView.findViewById(R.id.btnSimpan);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Emojifier emojiku = new Emojifier();
                    fotohasil = emojiku.detectFaces(view.getContext(), foto);
                    Intent intactivity = new Intent(view.getContext(),ResultPostActivity.class);
                    intactivity.putExtra("idfoto", fotohasil);

                    String mytext = editText.getText().toString();
                    String textku = editText1.getText().toString();
                    String locationku = location.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("textku", textku);
                    bundle.putString("mytext",mytext);
                    bundle.putString("locationku", locationku);
                    intactivity.putExtras(bundle);

                    String txtTanggal = editText1.getText().toString();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("textTanggal",txtTanggal);
                    intactivity.putExtras(bundle2);
                    startActivity(intactivity);


                }
            });
        //return fragment
        return myFragmentView;
    }

    //hasil foto dr kamera
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        foto = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(foto);
    }

    public void setEmoji(long id) {
        this.emojiId = id;
    }
}