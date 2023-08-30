package com.sandbox.myattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDataIjin extends RecyclerView.Adapter<AdapterDataIjin.ViewHolder> {
    private ArrayList<DataIjin> listIjin;
    private Context context;

    //Membuat Konstruktor, untuk menerima input dari Database
    public AdapterDataIjin(ArrayList<DataIjin> listIjin, Context context) {
        this.listIjin = listIjin;
        this.context = context;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Tgl, Jam, Keterangan;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View yang terpasang pada layout RecyclerView kita
            Tgl = itemView.findViewById(R.id.view_ijin_tgl);
            Jam = itemView.findViewById(R.id.view_ijin_jam);
            Keterangan = itemView.findViewById(R.id.view_ijin_keterangan);
            ListItem = itemView.findViewById(R.id.list_item_ijin);
        }
    }

    @Override
    public AdapterDataIjin.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_data_ijin, parent, false);
        return new AdapterDataIjin.ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(AdapterDataIjin.ViewHolder holder, final int position) {
        //Mengambil Nilai/Value yenag terdapat pada RecyclerView berdasarkan Posisi Tertentu
        final String Tgl = listIjin.get(position).getTanggal();
        final String Jam = listIjin.get(position).getJam();
        final String Keterangan = listIjin.get(position).getKeterangan();

        holder.Tgl.setText("Tanggal : "+Tgl);
        holder.Jam.setText("Jam : "+Jam);
        holder.Keterangan.setText("Keterangan : "+Keterangan);

    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return listIjin.size();
    }
}
