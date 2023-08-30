package com.sandbox.myattendance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ListMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);
    }

    public void clickDashboard(View view) {
        Intent i = new Intent(ListMenu.this, HomeAttendance.class);
        startActivity(i);
    }

    public void clickLokasi(View view) {
        Intent i = new Intent(ListMenu.this, MapsActivity.class);
        startActivity(i);
    }

    public void clickIjin(View view) {
        Intent i = new Intent(ListMenu.this, FormIjin.class);
        startActivity(i);
    }

    public void clickLembur(View view) {
        Intent i = new Intent(ListMenu.this, FormLembur.class);
        startActivity(i);
    }

    public void clickCuti(View view) {
        Intent i = new Intent(ListMenu.this, FormCuti.class);
        startActivity(i);
    }
  
    public void clickAbout(View view) {
        Intent i = new Intent(ListMenu.this, about.class);
        startActivity(i);
    }

    public void clickJadwal(View view) {
        Intent i = new Intent(ListMenu.this, JadwalActivity.class);
        startActivity(i);
    }

    public void clickListKaryawan(View view) {
        Intent i = new Intent(ListMenu.this, LihatKaryawanActivity.class);
        startActivity(i);
    }

    public void clicHistoryAttendance(View view) {
        Intent i = new Intent(ListMenu.this, HistoryAttendance.class);
        startActivity(i);
    }

}