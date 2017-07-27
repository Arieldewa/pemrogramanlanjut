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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Day6gridview2 extends AppCompatActivity {

    private ArrayList<String> hewan= new ArrayList<>();
    String data;
    ArrayList<String> datahewan = new ArrayList<>();
    private GridView grid;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6gridview2);
            hewan.add("singa");
            hewan.add("kera");
            hewan.add("sapi");

            adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,hewan);
            grid = (GridView) findViewById(R.id.gridhewan);
            grid.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
            grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                SparseBooleanArray clickedItemPositions = grid.getCheckedItemPositions();
                datahewan.clear();
                for(int index=0;index<clickedItemPositions.size();index++){
                    boolean checked = clickedItemPositions.valueAt(index);
                    if(checked){
                        int key = clickedItemPositions.keyAt(index);
                        String item = (String) adapter.getItem(key);
                        datahewan.add(item);
                    }
                }
                //data = buah.get(position);
                Intent mylocal = getIntent();
                Bundle mybundle = new Bundle();
                Log.d("day", "onCreate: "+data);
                mybundle.putString("data", data);
                mybundle.putStringArrayList("arraydata", datahewan);
                mylocal.putExtras(mybundle);
                setResult(Activity.RESULT_OK, mylocal);
            }
        });

    }

}

