package com.sandbox.myattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormCuti extends AppCompatActivity {
    EditText tgl_awal;
    EditText tgl_selesai;
    EditText keterangan;
    Button submit, btnLihatCuti;
    DatabaseReference reff;
    DataCuti cuti;
    private String in_tgl_awal, in_tgl_selesai, in_keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cuti);

        tgl_awal = (EditText)findViewById(R.id.cuti_tgl_awal);
        tgl_selesai = (EditText)findViewById(R.id.cuti_tgl_selesai);
        keterangan = (EditText) findViewById(R.id.cuti_keterangan);
        submit = (Button)findViewById(R.id.submitCuti);
        cuti = new DataCuti();
        reff = FirebaseDatabase.getInstance().getReference().child("DataCuti");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in_tgl_awal = tgl_awal.getText().toString().trim();
                in_tgl_selesai = tgl_selesai.getText().toString().trim();
                in_keterangan = keterangan.getText().toString().trim();

                if(TextUtils.isEmpty(in_tgl_awal) || TextUtils.isEmpty(in_tgl_selesai) || TextUtils.isEmpty(in_keterangan)) {
                    Toast.makeText(FormCuti.this, "Data Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                } else {
                    cuti.setTgl_awal(in_tgl_awal);
                    cuti.setTgl_selesai(in_tgl_selesai);
                    cuti.setKeterangan(in_keterangan);
                    reff.push().setValue(cuti);
                    Toast.makeText(FormCuti.this, "Data Tersimpan", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLihatCuti = (Button) findViewById(R.id.lihatCuti);
        btnLihatCuti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FormCuti.this, ListDataCuti.class);
                startActivity(i);
            }
        });
    }
}