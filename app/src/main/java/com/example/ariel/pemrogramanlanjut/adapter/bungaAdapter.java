package com.example.ariel.pemrogramanlanjut.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ariel.pemrogramanlanjut.R;
import com.example.ariel.pemrogramanlanjut.object.Bunga;

import java.util.ArrayList;

/**
 * Created by Ariel on 4/14/2017.
 */

public class bungaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Bunga> data;
    public ArrayList<Integer> selectedPositions;

    public bungaAdapter(Context context, ArrayList<Bunga> data) {
        this.context = context;
        this.data = data;
        selectedPositions = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            grid = new View(context);
            grid = inflater.inflate(R.layout.grid_bunga, null);
            TextView tv = (TextView) grid.findViewById(R.id.grid_namabunga);
            ImageView iv = (ImageView) grid.findViewById(R.id.grid_pic);
            tv.setText(data.get(i).getBunga());
            iv.setImageResource(data.get(i).getPict());
        }else{
            grid = (View) view;
        }
        display(data.get(i).getBunga(), selectedPositions.contains(i));
        return grid;
    }
    public void display(String text, boolean isSelected) {
        display(isSelected);
    }

    public void display(boolean isSelected) {

    }
}
