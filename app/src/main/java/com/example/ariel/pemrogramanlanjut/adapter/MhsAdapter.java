package com.example.ariel.pemrogramanlanjut.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ariel.pemrogramanlanjut.R;
import com.example.ariel.pemrogramanlanjut.object.Mahasiswa;

import java.util.ArrayList;

/**
 * Created by Ariel on 3/27/2017.
 */

public class MhsAdapter extends ArrayAdapter {

    ArrayList <Mahasiswa> data = new ArrayList<>();
    public MhsAdapter(Context context, int resource, ArrayList objects) {
        super(context, resource, objects);
        data = objects;
    }

    public int getCount() {
        return super.getCount();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.grid_mhs, null);
        TextView textView = (TextView) v.findViewById(R.id.nama);
        ImageView imageView = (ImageView) v.findViewById(R.id.fotomhs);
        textView.setText(data.get(position).getNama());
        imageView.setImageResource(data.get(position).getImg());

        return v;

    }

}
