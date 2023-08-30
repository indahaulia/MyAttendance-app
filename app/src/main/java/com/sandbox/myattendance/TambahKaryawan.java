package com.sandbox.myattendance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TambahKaryawan extends AppCompatActivity {
    EditText nama;
    EditText ttl;
    EditText jabatan;
    EditText jenis;
    EditText email;
    EditText password;
    Button submit_akun;
    DatabaseKaryawan dbHandler;
    KaryawanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_attendance);

        dbHandler = new DatabaseKaryawan(this);
        initComponents();
    }
    private void initComponents(){
        nama = (EditText)findViewById(R.id.edt_reg_nama);
        ttl = (EditText)findViewById(R.id.edt_reg_ttl);
        jabatan = (EditText)findViewById(R.id.edt_reg_jabatan);
        jenis = (EditText)findViewById(R.id.edt_reg_jenis);
        email = (EditText) findViewById(R.id.edt_reg_code);
        password = (EditText) findViewById(R.id.edt_reg_new_pass);
        submit_akun = (Button)findViewById(R.id.submit_akun);
        submit_akun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                validasiForm();
            }
        });
    }
    // FUNGSI INI UNTUK MEMVALIDASI FORM JIKA ADA YANG KOSONG ATAU TIDAK
    // LALU DILANJUT UNTUK MENJALANKAN PERINTAH SELANJUTNYA
    private void validasiForm(){
        String form_nama = nama.getText().toString();
        String form_tempatlahir = ttl.getText().toString();
        String form_jabatan = jabatan.getText().toString();
        String form_jenis = jenis.getText().toString();
        String form_email = email.getText().toString();
        String form_password= password.getText().toString();

        if (form_nama.isEmpty()){
            nama.setError("Isi nama dulu");
            nama.requestFocus();
        } if (form_tempatlahir.isEmpty()){
            ttl.setError("Isi tempat lahir dulu");
            ttl.requestFocus();
        } if (form_jabatan.isEmpty()){
            jabatan.setError("Isi jabatan dulu");
            jabatan.requestFocus();
        }if (form_jenis.isEmpty()){
            jenis.setError("Isi jenis dulu");
            jenis.requestFocus();
        }if (form_email.isEmpty()){
            email.setError("Isi email dulu");
            email.requestFocus();
        }if (form_password.isEmpty()){
            password.setError("Isi password dulu");
            password.requestFocus();
        }
        else {
            dbHandler.tambahKaryawan(new Karyawan(form_nama, form_tempatlahir, form_jabatan, form_jenis, form_email, form_password));
            List<Karyawan> karyawanList = dbHandler.getSemuaKaryawan();
            adapter = new KaryawanAdapter(karyawanList);
            adapter.notifyDataSetChanged();
            Toast.makeText(TambahKaryawan.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(TambahKaryawan.this, LoginAttendance.class);
            startActivity(i);
        }
    }
}