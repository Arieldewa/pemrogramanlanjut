package com.example.ariel.pemrogramanlanjut;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Day5 extends AppCompatActivity {

    private Button btnI0;
    private Button btnI1;
    private Button btnI2;
    private Button btnI3;
    private Button btnI4;
    private Button btnI5;
    private Button btnI6;
    private Button btnI7;
    private Button btnI8;
    private Button btnI9;
    private Button btnI10;
    private Button btnI11;
    private Button btnI12;
    private Button btnI13;
    private Button btnI14;
    private Button btnI15;
    private Button btnI16;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day5);
        btnI0 = (Button) findViewById(R.id.intent0);
        btnI1 = (Button) findViewById(R.id.intent1);
        btnI2 = (Button) findViewById(R.id.intent2);
        btnI3 = (Button) findViewById(R.id.intent3);
        btnI4 = (Button) findViewById(R.id.intent4);
        btnI5 = (Button) findViewById(R.id.intent5);
        btnI6 = (Button) findViewById(R.id.intent6);
        btnI7 = (Button) findViewById(R.id.intent7);
        btnI8 = (Button) findViewById(R.id.intent8);
        btnI9 = (Button) findViewById(R.id.intent9);
        btnI10 = (Button) findViewById(R.id.intent10);
        btnI11 = (Button) findViewById(R.id.intent11);
        btnI12 = (Button) findViewById(R.id.intent12);
        btnI13 = (Button) findViewById(R.id.intent13);
        btnI14 = (Button) findViewById(R.id.intent14);
        btnI15 = (Button) findViewById(R.id.intent15);
        btnI16 = (Button) findViewById(R.id.intent16);

        btnI0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Intent.ACTION_DIAL);
                startActivity(i);
            }
        });
        btnI1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Intent.ACTION_WEB_SEARCH);
                i.putExtra(SearchManager.QUERY,"Tutorial Android");
                startActivity(i);
            }
        });
        btnI2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Intent.ACTION_SENDTO,Uri.parse("sms://"));
                //i.putExtra("address", "555-1234"); untuk alamat
                // i.putExtra("sms_body", "remember to buy bread and milk");untuk sms body nya
                startActivity(i);
            }
        });
        btnI3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent();
                i.setType("image/pictures/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(i);
            }
        });
        btnI4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no = "tel:087758384592";
                i = new Intent(Intent.ACTION_DIAL,Uri.parse(no));
                startActivity(i);
            }
        });
        btnI5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myData = "content://contacts/people/";
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(myData));
                startActivity(i);
            }
        });
        btnI6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idkontak = "content://contacts/people/5";
                i = new Intent(Intent.ACTION_VIEW,Uri.parse(idkontak));
                startActivity(i);
            }
        });
        btnI7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idkontak = "content://contacts/people/5";
                i = new Intent(Intent.ACTION_EDIT,Uri.parse(idkontak));
                startActivity(i);
            }
        });
        btnI8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myData = "http://www.youTube.com";
                i = new Intent(Intent.ACTION_VIEW,Uri.parse(myData));
                startActivity(i);
            }
        });
        btnI9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String geo ="geo:0,0?q=politeknik+elektronika+negeri+surabaya";
                i = new Intent(Intent.ACTION_VIEW,Uri.parse(geo));
                startActivity(i);
            }
        });
        btnI10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String geo ="geo:41.5020952,-81.6789717";
                i = new Intent(Intent.ACTION_VIEW,Uri.parse(geo));
                startActivity(i);
            }
        });
        btnI11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String geoCode =
                        "google.streetview:cbll=41.5020952,-81.6789717&cbp=1,270,,45,1&mz=1";
                i = new Intent(Intent.ACTION_VIEW,Uri.parse(geoCode));
                startActivity(i);
            }
        });
        btnI12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent("android.intent.action.MUSIC_PLAYER");
                startActivity(i);
            }
        });
        btnI13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("file:///storage/sdcard1/Adel-Hello_.mp3");
                String type = "audio/mp3";
                i.setDataAndType(data, type);
                startActivity(i);
            }
        });
        btnI14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:v.matos@csuohio.edu");
                i = new Intent(Intent.ACTION_SENDTO, uri);
                // you may skip the next two pieces [subject/text]
                i.putExtra(Intent.EXTRA_SUBJECT,"subject goes here");
                i.putExtra(Intent.EXTRA_TEXT,"The email's body goes here");
                startActivity(i);
            }
        });
        btnI15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(android.provider.Settings.ACTION_SETTINGS);
                startActivity(i);
            }
        });
        btnI16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(android.provider.Settings.ACTION_LOCALE_SETTINGS);
                startActivity(i);
            }
        });
    }
}
