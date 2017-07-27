package com.example.ariel.pemrogramanlanjut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ariel.pemrogramanlanjut.helper.DatabaseHandler;
import com.example.ariel.pemrogramanlanjut.object.PensMHS;

public class FormDetailMhs extends AppCompatActivity {

    private TextView nrp,nama,jurusan;
    private Button btnupdate,btndelete;
    private PensMHS mhs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_detail_mhs);

        Intent i = getIntent();

        DatabaseHandler db = new DatabaseHandler(this);

        mhs = db.getMhs(i.getIntExtra("id",0));
        nrp = (TextView) findViewById(R.id.detailnrp);
        nama = (TextView) findViewById(R.id.detailnama);
        jurusan = (TextView) findViewById(R.id.detailjurusan);
        btnupdate = (Button) findViewById(R.id.btnupdate);
        btndelete = (Button) findViewById(R.id.btndelete);

        nrp.setText(String.valueOf(mhs.getNrp()));
        nama.setText(mhs.getName());
        jurusan.setText(mhs.getJurusan());

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (FormDetailMhs.this,FormUpdateMhs.class);
                i.putExtra("id",mhs.getNrp());
                startActivity(i);
                finish();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                db.deleteMHS(mhs);
                Intent i = new Intent(FormDetailMhs.this,Day8.class);
                startActivity(i);
                finish();
            }
        });
    }
}
