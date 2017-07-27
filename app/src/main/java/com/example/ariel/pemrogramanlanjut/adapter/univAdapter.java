package com.example.ariel.pemrogramanlanjut.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ariel.pemrogramanlanjut.R;
import com.example.ariel.pemrogramanlanjut.object.Universitas;

import java.util.ArrayList;

/**
 * Created by Ariel on 4/14/2017.
 */

public class univAdapter extends ArrayAdapter<Universitas> {
    private ArrayList<Universitas> data;
    private Context context ;

    public univAdapter(Context context, ArrayList<Universitas> data) {
        super(context, R.layout.list_univ, data);
        this.data = data;
        this.context = context;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_univ,parent,false);
        TextView tv = (TextView) rowView.findViewById(R.id.univ);
        tv.setText(data.get(position).getUniv());

        return rowView;
    }
}
