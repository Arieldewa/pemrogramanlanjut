package com.example.ariel.pemrogramanlanjut.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ariel.pemrogramanlanjut.R;

import java.util.ArrayList;

/**
 * Created by Ariel on 4/14/2017.
 */

public class buahAdapter extends ArrayAdapter<String> {
    private ArrayList<String> data;
    private Context context ;

    public buahAdapter(Context context, ArrayList<String> data) {
        super(context, android.R.layout.simple_list_item_multiple_choice, data);
        this.data = data;
        this.context = context;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(android.R.layout.simple_list_item_multiple_choice,parent,false);
        TextView tv = (TextView) rowView.findViewById(android.R.id.text1);
        tv.setText(data.get(position));
        return rowView;
    }
}
