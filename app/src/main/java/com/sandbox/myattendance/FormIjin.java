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

public class FormIjin extends AppCompatActivity {
    EditText tanggal;
    EditText jam;
    EditText keterangan;
    Button submit, btnLihatIjin;
    DatabaseReference reff;
    DataIjin ijin;
    private String in_tanggal, in_jam, in_keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ijin);

        tanggal = (EditText)findViewById(R.id.ijin_tgl);
        jam = (EditText)findViewById(R.id.ijin_jam);
        keterangan = (EditText) findViewById(R.id.ijin_keterangan);
        submit = (Button)findViewById(R.id.submitIjin);
        ijin = new DataIjin();
        reff = FirebaseDatabase.getInstance().getReference().child("DataIjin");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in_tanggal = tanggal.getText().toString().trim();
                in_jam = jam.getText().toString().trim();
                in_keterangan = keterangan.getText().toString().trim();

                if(TextUtils.isEmpty(in_tanggal) || TextUtils.isEmpty(in_jam) || TextUtils.isEmpty(in_keterangan)) {
                    Toast.makeText(FormIjin.this, "Data Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                } else {
                    ijin.setTanggal(in_tanggal);
                    ijin.setJam(in_jam);
                    ijin.setKeterangan(in_keterangan);
                    reff.push().setValue(ijin);
                    Toast.makeText(FormIjin.this, "Data Tersimpan", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLihatIjin = (Button) findViewById(R.id.lihatIjin);
        btnLihatIjin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FormIjin.this, ListDataIjin.class);
                startActivity(i);
            }
        });
    }
}