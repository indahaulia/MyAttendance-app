package com.sandbox.myattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDataCuti extends RecyclerView.Adapter<AdapterDataCuti.ViewHolder>{
    private ArrayList<DataCuti> listCuti;
    private Context context;

    //Membuat Konstruktor, untuk menerima input dari Database
    public AdapterDataCuti(ArrayList<DataCuti> listCuti, Context context) {
        this.listCuti = listCuti;
        this.context = context;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView TglMulai, TglSelesai, Keterangan;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View yang terpasang pada layout RecyclerView kita
            TglMulai = itemView.findViewById(R.id.view_cuti_tgl_mulai);
            TglSelesai = itemView.findViewById(R.id.view_cuti_tgl_selesai);
            Keterangan = itemView.findViewById(R.id.view_cuti_keterangan);
            ListItem = itemView.findViewById(R.id.list_item_cuti);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_data_cuti, parent, false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //Mengambil Nilai/Value yenag terdapat pada RecyclerView berdasarkan Posisi Tertentu
        final String TglMulai = listCuti.get(position).getTgl_awal();
        final String TglSelesai = listCuti.get(position).getTgl_selesai();
        final String Keterangan = listCuti.get(position).getKeterangan();

        //Memasukan Nilai/Value kedalam View (TextView: NIM, Nama, Jurusan)
        holder.TglMulai.setText("Tanggal Mulai : "+TglMulai);
        holder.TglSelesai.setText("Tanggal Selesai : "+TglSelesai);
        holder.Keterangan.setText("Keterangan : "+Keterangan);

    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return listCuti.size();
    }

}
