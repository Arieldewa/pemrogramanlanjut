package com.example.ariel.pemrogramanlanjut;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ariel.pemrogramanlanjut.adapter.MhsAdapter;
import com.example.ariel.pemrogramanlanjut.object.Mahasiswa;

import java.util.ArrayList;

public class Day4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private GridView gv;
    private ArrayList mhs = new ArrayList();
    private String[] kelas;
    private MhsAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day4);

        kelas = new String[]{"1 D3", "2 D3", "3 D3","Semua"};
        Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,kelas);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(this);

        mhs.add(new Mahasiswa("will","Ponorogo",1,R.drawable.will_smith));
        mhs.add(new Mahasiswa("Angelina Jolie","Ponorogo",2,R.drawable.angelina_jolie));
        mhs.add(new Mahasiswa("emma","Ponorogo",3,R.drawable.emma));

        gv = (GridView) findViewById(R.id.gridview);
        myAdapter=new MhsAdapter(this,R.layout.grid_mhs,mhs);
        gv.setAdapter(myAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if(kelas[i].equals("1 D3")){
                mhs.clear();
                mhs.add(new Mahasiswa("will","Ponorogo",1,R.drawable.will_smith));
                mhs.add(new Mahasiswa("Angelina Jolie","Ponorogo",2,R.drawable.angelina_jolie));
                mhs.add(new Mahasiswa("emma","Ponorogo",3,R.drawable.emma));
            }
            if(kelas[i].equals("2 D3")){
                mhs.clear();
                mhs.add(new Mahasiswa("Shailen","Ponorogo",4,R.drawable.divergent));
                mhs.add(new Mahasiswa("Emma Robert","Ponorogo",5,R.drawable.emma_roberts));
                mhs.add(new Mahasiswa("Mila Kunis","Ponorogo",6,R.drawable.mila_kunis));
            }
            if(kelas[i].equals("3 D3")){
                mhs.clear();
                mhs.add(new Mahasiswa("Scarlet Johanson","Ponorogo",7,R.drawable.scarlett_johansson));
            }
            if(kelas[i].equals("Semua")){
                mhs.clear();
                mhs.add(new Mahasiswa("will","Ponorogo",1,R.drawable.will_smith));
                mhs.add(new Mahasiswa("Angelina Jolie","Ponorogo",2,R.drawable.angelina_jolie));
                mhs.add(new Mahasiswa("emma","Ponorogo",3,R.drawable.emma));
                mhs.add(new Mahasiswa("Shailen","Ponorogo",4,R.drawable.divergent));
                mhs.add(new Mahasiswa("Emma Robert","Ponorogo",5,R.drawable.emma_roberts));
                mhs.add(new Mahasiswa("Mila Kunis","Ponorogo",6,R.drawable.mila_kunis));
                mhs.add(new Mahasiswa("Scarlet Johanson","Ponorogo",7,R.drawable.scarlett_johansson));
            }
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
