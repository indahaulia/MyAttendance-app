package com.sandbox.myattendance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LihatKaryawanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private KaryawanAdapter adapter;
    private DatabaseKaryawan dbHandler;
    private TextView txt_resultadapter;
    private List<Karyawan> karyawanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_karyawan);

        initComponents();
        initRecyclerView();
        cekDataRecyclerView();
    }
    // FUNGSI INI UNTUK MENG-INIT RECYLERVIEW BESERTA ADAPTERNYA
    private void initRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.daftarKaryawan);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dbHandler = new DatabaseKaryawan(LihatKaryawanActivity.this);
        karyawanList = dbHandler.getSemuaKaryawan();
        adapter = new KaryawanAdapter(karyawanList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void initComponents(){
        txt_resultadapter = (TextView) findViewById(R.id.txt_resultadapter);
    }

    // FUNGSI INI UNTUK MENGECEK APAKAH ADA DATA DI DALEM RECYCLERVIEW ATAU TIDAK
    private void cekDataRecyclerView(){
        if (adapter.getItemCount() == 0){
            txt_resultadapter.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            txt_resultadapter.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            // TODO Handle item click
                            Karyawan mhs = karyawanList.get(position);
                            String nama = mhs.getNama();
                            String ttl = mhs.getTempat_lahir();
                            String jabatan = mhs.getJabatan();
                            String jenis = mhs.getJenis_kl();
                            String email = mhs.getEmail();


                            Toast.makeText(LihatKaryawanActivity.this, "Klik di " + nama, Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LihatKaryawanActivity.this, DefaultActivity.class);
                            i.putExtra("nama",nama);
                            i.putExtra("ttl",ttl);
                            i.putExtra("jabatan",jabatan);
                            i.putExtra("jenis",jenis);
                            i.putExtra("email",email);
                            startActivity(i);
                        }
                    })
            );
        }
    }

}
