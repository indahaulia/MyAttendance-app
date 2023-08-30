package com.sandbox.myattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDataLembur extends RecyclerView.Adapter<AdapterDataLembur.ViewHolder>{
    private ArrayList<DataLembur> listLembur;
    private Context context;

    //Membuat Konstruktor, untuk menerima input dari Database
    public AdapterDataLembur(ArrayList<DataLembur> listLembur, Context context) {
        this.listLembur = listLembur;
        this.context = context;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Tgl, JamMulai, JamSelesai, Keterangan;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View yang terpasang pada layout RecyclerView kita
            Tgl = itemView.findViewById(R.id.view_lembur_tgl);
            JamMulai = itemView.findViewById(R.id.view_lembur_jam_mulai);
            JamSelesai = itemView.findViewById(R.id.view_lembur_jam_selesai);
            Keterangan = itemView.findViewById(R.id.view_lembur_keterangan);
            ListItem = itemView.findViewById(R.id.list_item_lembur);
        }
    }

    @Override
    public AdapterDataLembur.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_data_lembur, parent, false);
        return new AdapterDataLembur.ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(AdapterDataLembur.ViewHolder holder, final int position) {
        //Mengambil Nilai/Value yenag terdapat pada RecyclerView berdasarkan Posisi Tertentu
        final String Tgl = listLembur.get(position).getTanggal();
        final String JamMulai = listLembur.get(position).getJam_mulai();
        final String JamSelesai = listLembur.get(position).getJam_selesai();
        final String Keterangan = listLembur.get(position).getKeterangan();

        holder.Tgl.setText("Tanggal Mulai : "+Tgl);
        holder.JamMulai.setText("Tanggal Mulai : "+JamMulai);
        holder.JamSelesai.setText("Tanggal Selesai : "+JamSelesai);
        holder.Keterangan.setText("Keterangan : "+Keterangan);

    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return listLembur.size();
    }
}
