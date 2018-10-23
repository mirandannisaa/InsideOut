package com.example.okejon.insideout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.example.okejon.insideout.Emoji;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmojiListFragment extends ListFragment {

    static interface Listener{
        void itemClicked(long id);
    }
    private Listener listener;

    public EmojiListFragment() {
        // Required empty public constructor
    }

    // Method onCreateView dipanggil saat Fragment harus membuat layoutnya
// menggunakan objek View di Java secara dinamis atau membacanya dari XML.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names = new String[Emoji.insideout.length];
        for (int i=0; i<names.length; i++) {
            names[i] = Emoji.insideout[i].getNama();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    // Event ini dipanggil pertama kali sebelum pembuatan fragment atau pembacaan
// layout lain. Method onAttach dipanggil saat sebuah instance Fragment
// terhubung dengan sebuah Activity.
// Method ini tidak berarti Activity sudah dimuat sempurna

    @ Override
    public void onAttach ( Context context ){
        super . onAttach ( context );
        this . listener = (Listener) context ;
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id){
        if(listener != null){
            listener.itemClicked(id);
        }
    }
}