package com.example.ariel.pemrogramanlanjut.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.ariel.pemrogramanlanjut.R;

/**
 * Created by Ariel on 4/14/2017.
 */

public class GridViewItem extends FrameLayout {

    private TextView textView;

    public GridViewItem(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.grid_bunga, this);
        textView = (TextView) getRootView().findViewById(R.id.grid_namabunga);
    }

    public void display(String text, boolean isSelected) {
        textView.setText(text);
        display(isSelected);
    }

    public void display(boolean isSelected) {
        textView.setBackgroundResource(isSelected ? R.drawable.bluesquare : R.drawable.graysquare);
    }
}