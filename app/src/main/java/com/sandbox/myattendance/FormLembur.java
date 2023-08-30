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

public class FormLembur extends AppCompatActivity {
    EditText tanggal;
    EditText jam_mulai;
    EditText jam_selesai;
    EditText keterangan;
    Button submit, btnLihatLembur;
    DatabaseReference reff;
    DataLembur lembur;
    private String in_tanggal, in_jam_mulai, in_jam_selesai, in_keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_lembur);

        tanggal = (EditText)findViewById(R.id.lembur_tgl);
        jam_mulai = (EditText)findViewById(R.id.lembur_jam_mulai);
        jam_selesai = (EditText) findViewById(R.id.lembur_jam_selesai);
        keterangan = (EditText) findViewById(R.id.lembur_keterangan);
        submit = (Button)findViewById(R.id.submitLembur);
        lembur = new DataLembur();
        reff = FirebaseDatabase.getInstance().getReference().child("DataLembur");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in_tanggal = tanggal.getText().toString().trim();
                in_jam_mulai = jam_mulai.getText().toString().trim();
                in_jam_selesai = jam_selesai.getText().toString().trim();
                in_keterangan = keterangan.getText().toString().trim();

                if(TextUtils.isEmpty(in_tanggal) || TextUtils.isEmpty(in_jam_mulai) || TextUtils.isEmpty(in_jam_selesai) || TextUtils.isEmpty(in_keterangan)) {
                    Toast.makeText(FormLembur.this, "Data Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                } else {
                    lembur.setTanggal(in_tanggal);
                    lembur.setJam_mulai(in_jam_mulai);
                    lembur.setJam_selesai(in_jam_selesai);
                    lembur.setKeterangan(in_keterangan);
                    reff.push().setValue(lembur);
                    Toast.makeText(FormLembur.this, "Data Tersimpan", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLihatLembur = (Button) findViewById(R.id.lihatLembur);
        btnLihatLembur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FormLembur.this, ListDataLembur.class);
                startActivity(i);
            }
        });
    }
}