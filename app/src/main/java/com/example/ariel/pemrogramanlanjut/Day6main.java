package com.example.ariel.pemrogramanlanjut;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariel.pemrogramanlanjut.adapter.buahAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class Day6main extends AppCompatActivity {

    private Button btnlist,btngrid,btnhewan;
    private Intent i;
    private TextView tv;
    private ListView lv;
    private ArrayList<String> stringdata = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6main);

        btnlist = (Button) findViewById(R.id.listview);
        btngrid = (Button) findViewById(R.id.gridview);
        btnhewan = (Button) findViewById(R.id.gridviewhewan);
        lv = (ListView) findViewById(R.id.list);

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Day6main.this,Day6listview.class);
                startActivityForResult(i,1);
            }
        });
        btngrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Day6main.this,Day6gridview.class);
                startActivityForResult(i,2);
            }
        });
        btnhewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Day6main.this,Day6gridview2.class);
                startActivityForResult(i,3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            tv = (TextView) findViewById(R.id.hasil);
            tv.setText("");
            Bundle myresult = data.getExtras();
                if ((requestCode == 1) && (resultCode == Activity.RESULT_OK)) {
                    ArrayList<String> vardata = myresult.getStringArrayList("arraydata");
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,vardata);
                    lv.setAdapter(adapter);
                } else if ((requestCode == 2) && (resultCode == Activity.RESULT_OK)) {
                    ArrayList<String> vardata = myresult.getStringArrayList("arraydata");
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,vardata);
                    lv.setAdapter(adapter);
                } else if ((requestCode == 3) && (resultCode == Activity.RESULT_OK)) {
                    ArrayList<String> vardata = myresult.getStringArrayList("arraydata");
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,vardata);
                    lv.setAdapter(adapter);
                }
    }catch(Exception e) {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
        }
    }
}
