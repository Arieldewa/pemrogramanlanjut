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

public class FormUpdateMhs extends AppCompatActivity {

    private EditText nrp , nama, jurusan ;
    private Button btnupdate;
    private PensMHS mhs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_update_mhs);

        nrp = (EditText) findViewById(R.id.updatenrp);
        nama = (EditText) findViewById(R.id.updatenama);
        jurusan = (EditText) findViewById(R.id.updatejurusan);
        btnupdate = (Button) findViewById(R.id.btnupdate);

        Intent i = getIntent();

        DatabaseHandler db = new DatabaseHandler(this);

        mhs = db.getMhs(i.getIntExtra("id",0));

        nrp.setText(String.valueOf(mhs.getNrp()));
        nama.setText(mhs.getName());
        jurusan.setText(mhs.getJurusan());
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( nama.getText().toString().length() == 0 )
                    nama.setError( "Nama is required!" );
                if( jurusan.getText().toString().length() == 0 )
                    jurusan.setError( "Jurusan is required!" );
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                mhs.setName(String.valueOf(nama.getText()));
                mhs.setJurusan(String.valueOf(jurusan.getText()));
                db.updateMHS(mhs);
                Intent i = new Intent(FormUpdateMhs.this, Day8.class);
                i.putExtra("id",mhs.getNrp());
                startActivity(i);
                finish();
            }
        });
    }
}
