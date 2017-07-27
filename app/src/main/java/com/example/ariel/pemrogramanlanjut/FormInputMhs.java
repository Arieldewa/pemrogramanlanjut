package com.example.ariel.pemrogramanlanjut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ariel.pemrogramanlanjut.helper.DatabaseHandler;
import com.example.ariel.pemrogramanlanjut.object.PensMHS;

public class FormInputMhs extends AppCompatActivity {

    private EditText nrp,nama,jurusan;
    Button btnsimpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input_mhs);

        nrp =(EditText) findViewById(R.id.inputnrp);
        nama =(EditText) findViewById(R.id.inputnama);
        jurusan=(EditText) findViewById(R.id.inputjurusan);
        btnsimpan = (Button) findViewById(R.id.btnsimpan);

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( nrp.getText().toString().length() == 0 )
                    nrp.setError( "Nrp is required!" );
                if( nama.getText().toString().length() == 0 )
                    nama.setError( "Nama is required!" );
                if( jurusan.getText().toString().length() == 0 )
                    jurusan.setError( "Jurusan is required!" );

                int inrp = Integer.parseInt(String.valueOf(nrp.getText()));
                String inama = String.valueOf(nama.getText());
                String ijurusan = (String.valueOf(jurusan.getText()));
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                db.addMHS(new PensMHS(inrp,inama,ijurusan));
                Intent i = new Intent(FormInputMhs.this,Day8.class);
                startActivity(i);
                finish();
            }
        });
    }
}
