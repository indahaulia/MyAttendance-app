package com.sandbox.myattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeAttendance extends AppCompatActivity {
    DatabaseReference reff;
    DataAbsensi absensi;
    Button btnHistoryAbsensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_attendance);
        TextView waktu_sekarang = (TextView) findViewById(R.id.waktu_sekarang);
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        String currentTime = time.format(new Date());
        waktu_sekarang.setText(currentTime);

        TextView tanggal_sekarang = (TextView) findViewById(R.id.tanggal_sekarang);
        SimpleDateFormat date = new SimpleDateFormat("EEE, d MMMM yyyy", Locale.ENGLISH);
        String currentDate = date.format(new Date());
        tanggal_sekarang.setText(currentDate);

        absensi = new DataAbsensi();
        reff = FirebaseDatabase.getInstance().getReference().child("DataAbsensi");

        btnHistoryAbsensi = (Button) findViewById(R.id.history_attendance);
        btnHistoryAbsensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAttendance.this, HistoryAttendance.class);
                startActivity(i);
            }
        });
    }

    public void checkIn(View view) {
        SimpleDateFormat dateTimeIn = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String dataCheckIn = dateTimeIn.format(new Date());

        absensi.setCheck_in(dataCheckIn);
        reff.push().setValue(absensi);
        Intent i = new Intent(HomeAttendance.this, SuccessActivity.class);
        startActivity(i);
    }

    public void checkOut(View view) {
        SimpleDateFormat dateTimeOut = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String dataCheckOut = dateTimeOut.format(new Date());

        absensi.setCheck_out(dataCheckOut);
        reff.push().setValue(absensi);
        Intent i = new Intent(HomeAttendance.this, SuccessOut.class);
        startActivity(i);
    }


    public void clickMenu(View view) {
        Intent i = new Intent(HomeAttendance.this, ListMenu.class);
        startActivity(i);
    }


}