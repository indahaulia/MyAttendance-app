package com.sandbox.myattendance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DefaultActivity extends AppCompatActivity {

    TextView textName;
    TextView textTTL;
    TextView textJabatan;
    TextView textJenis;
    TextView textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        textName = findViewById(R.id.namaview);
        textTTL = findViewById(R.id.ttl_view);
        textJabatan = findViewById(R.id.jabatanview);
        textJenis = findViewById(R.id.jenisview);
        textEmail = findViewById(R.id.emailview);

        Intent intent = getIntent();
        String namaKaryawanDef = intent.getStringExtra("nama");
        String ttlDef = intent.getStringExtra("ttl");
        String jabatanDef = intent.getStringExtra("jabatan");
        String jenisDef = intent.getStringExtra("jenis");
        String emailDef = intent.getStringExtra("email");

        textName.setText(namaKaryawanDef);
        textTTL.setText(ttlDef);
        textJabatan.setText(jabatanDef);
        textJenis.setText(jenisDef);
        textEmail.setText(emailDef);
    }
}