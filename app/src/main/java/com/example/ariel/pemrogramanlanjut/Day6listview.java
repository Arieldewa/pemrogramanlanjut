package com.example.ariel.pemrogramanlanjut;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ariel.pemrogramanlanjut.adapter.buahAdapter;

import java.util.ArrayList;
import java.util.List;

public class Day6listview extends ListActivity {

    private ArrayList<String> buah= new ArrayList<>();
    String data;
    ArrayList<String> databuah = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6listview);
        buah.add("Apel");
        buah.add("Mangga");
        buah.add("Semangka");
        buah.add("Nanas");
        buah.add("Bengkoang");
        buah.add("Per");
        buahAdapter adapter = new buahAdapter(this,buah);
        setListAdapter(adapter);
    }
    public void onListItemClick(ListView parent, View v, int position, long id){
        SparseBooleanArray clickedItemPositions = parent.getCheckedItemPositions();
        databuah.clear();
        for(int index=0;index<clickedItemPositions.size();index++){
            boolean checked = clickedItemPositions.valueAt(index);
            if(checked){
                int key = clickedItemPositions.keyAt(index);
                String item = (String) parent.getItemAtPosition(key);
                databuah.add(item);
            }
        }
        data = buah.get(position);
        Intent mylocal = getIntent();
        Bundle mybundle = new Bundle();
        Log.d("day", "onCreate: "+data);
        mybundle.putString("data", data);
        mybundle.putStringArrayList("arraydata", databuah);
        mylocal.putExtras(mybundle);
        setResult(Activity.RESULT_OK, mylocal);
        Toast.makeText(this,"You have selected " + buah.get(position),Toast.LENGTH_SHORT).show();
    }

}
