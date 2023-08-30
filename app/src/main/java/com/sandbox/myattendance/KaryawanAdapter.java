package com.sandbox.myattendance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KaryawanAdapter extends RecyclerView.Adapter<KaryawanAdapter.KaryawanViewHolder> {
    private List<Karyawan> karyawanList = new ArrayList<>();

    public KaryawanAdapter(List<Karyawan> karyawanList) {
        this.karyawanList = karyawanList;
    }

    @Override
    public KaryawanAdapter.KaryawanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_karyawan, parent, false);
        KaryawanViewHolder karyawanViewHolder = new KaryawanViewHolder(view);
        return karyawanViewHolder;
    }

    @Override
    public void onBindViewHolder(KaryawanAdapter.KaryawanViewHolder holder, int position) {
        holder.tv_nama.setText(karyawanList.get(position).getNama());
        holder.tv_jabatan.setText(karyawanList.get(position).getJabatan());
    }

    @Override
    public int getItemCount() {
        return karyawanList.size();
    }

    public static class KaryawanViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        TextView tv_nama;
        TextView jabatan;
        TextView tv_jabatan;

        public KaryawanViewHolder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.nama);
            tv_nama = (TextView) itemView.findViewById(R.id.tv_nama);
            jabatan = (TextView) itemView.findViewById(R.id.jabatan);
            tv_jabatan = (TextView) itemView.findViewById(R.id.tv_jabatan);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
