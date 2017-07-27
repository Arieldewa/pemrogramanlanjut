package com.example.ariel.pemrogramanlanjut;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.ariel.pemrogramanlanjut.adapter.PensMHSAdapter;
import com.example.ariel.pemrogramanlanjut.helper.DatabaseHandler;
import com.example.ariel.pemrogramanlanjut.object.PensMHS;

import java.util.ArrayList;

public class Day8 extends AppCompatActivity {

    RecyclerView recyclerView;
    PensMHSAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<PensMHS> datamhs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day8);

        DatabaseHandler db = new DatabaseHandler(this);

        datamhs = db.getAllMHS();
        initView();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        FloatingActionButton updateall = (FloatingActionButton) findViewById(R.id.updateall);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i = new Intent (Day8.this,FormInputMhs.class);
                startActivity(i);
                finish();
            }
        });
        updateall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(getApplicationContext());
                View promptsView = li.inflate(R.layout.prompt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        getApplicationContext());

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                                        db.updateAllmhs();
                                        datamhs = db.getAllMHS();
                                        adapter.notifyDataSetChanged();
                                        adapter = new PensMHSAdapter(datamhs,getApplicationContext());
                                        recyclerView.setAdapter(adapter);
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rvall);
        layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PensMHSAdapter(datamhs,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}
