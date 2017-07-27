package com.example.ariel.pemrogramanlanjut;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.ariel.pemrogramanlanjut.adapter.bungaAdapter;
import com.example.ariel.pemrogramanlanjut.object.Bunga;

import java.util.ArrayList;

public class Day6gridview extends AppCompatActivity {

    private GridView grid;
    private ArrayList<String> bunga = new ArrayList<>();
    private ArrayList<String> selectedStrings = new ArrayList<String>();
    private String data;
    private  ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6gridview);

        bunga.add("Mawar");
        bunga.add("Matahari");
        bunga.add("Melati");
        bunga.add("Raflesia");
        bunga.add("Anggrek");
        bunga.add("Kamboja");
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,bunga);
        grid = (GridView) findViewById(R.id.grid);
        grid.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                SparseBooleanArray clickedItemPositions = grid.getCheckedItemPositions();
                selectedStrings.clear();
                for(int index=0;index<clickedItemPositions.size();index++){
                    boolean checked = clickedItemPositions.valueAt(index);
                    if(checked){
                        int key = clickedItemPositions.keyAt(index);
                        String item = (String) adapter.getItem(key);
                        selectedStrings.add(item);
                    }
                }
                //data = buah.get(position);
                Intent mylocal = getIntent();
                Bundle mybundle = new Bundle();
                Log.d("day", "onCreate: "+data);
                mybundle.putString("data", data);
                mybundle.putStringArrayList("arraydata", selectedStrings);
                mylocal.putExtras(mybundle);
                setResult(Activity.RESULT_OK, mylocal);
            }
        });

    }
}
