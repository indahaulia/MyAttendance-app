package com.sandbox.myattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.ViewHolder>{
    private ArrayList<DataAbsensi> dataAbsensi;
    private Context context;

    //Membuat Konstruktor, untuk menerima input dari Database
    public AdapterHistory(ArrayList<DataAbsensi> dataAbsensi, Context context) {
        this.dataAbsensi = dataAbsensi;
        this.context = context;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView view_waktu_checkin, view_waktu_checkout;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View yang terpasang pada layout RecyclerView kita
            view_waktu_checkin = itemView.findViewById(R.id.view_waktu_checkin);
            view_waktu_checkout = itemView.findViewById(R.id.view_waktu_checkout);
            ListItem = itemView.findViewById(R.id.list_item_absensi);
        }
    }

    @Override
    public AdapterHistory.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_data_absensi, parent, false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(AdapterHistory.ViewHolder holder, final int position) {
        //Mengambil Nilai/Value yenag terdapat pada RecyclerView berdasarkan Posisi Tertentu
        final String checkin = dataAbsensi.get(position).getCheck_in();
        final String checkout = dataAbsensi.get(position).getCheck_out();

        holder.view_waktu_checkin.setText("Waktu Check In : "+checkin);
        holder.view_waktu_checkout.setText("Waktu Check Out : "+checkout);

    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return dataAbsensi.size();
    }
}
