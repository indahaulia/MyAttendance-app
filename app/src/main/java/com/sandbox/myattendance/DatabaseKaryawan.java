package com.sandbox.myattendance;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseKaryawan extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "db_karyawan";
    public static final String TABLE_KARYAWAN = "table_karyawan";
    public static final String COLUMN_ID = "id"; // NAMA KOLOM ID
    public static final String COLUMN_NAMA = "nama"; // NAMA KOLOM NAMA
    public static final String COLUMN_TEMPATLAHIR = "tempat_lahir"; // NAMA KOLOM TEMPAT LAHIR
    public static final String COLUMN_JABATAN = "jabatan"; // NAMA KOLOM JABATAN
    public static final String COLUMN_JENISKL = "jenis_kl"; // NAMA KOLOM JENIS KELAMIN
    public static final String COLUMN_EMAIL = "email"; // NAMA KOLOM EMAIL
    public static final String COLUMN_PASSWORD = "password"; // NAMA KOLOM PASSWORD
    public static final int DATABASE_VERTION = 1;

    public DatabaseKaryawan(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERTION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_KARYAWAN + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAMA + " TEXT,"
                + COLUMN_TEMPATLAHIR + " TEXT," + COLUMN_JABATAN + " TEXT," + COLUMN_JENISKL + " TEXT,"
                + COLUMN_EMAIL + " TEXT," + COLUMN_PASSWORD + " TEXT" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KARYAWAN);
        onCreate(db);
    }

    //Metode untuk tambah data
    public void tambahKaryawan(Karyawan karyawan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA, karyawan.getNama());
        values.put(COLUMN_TEMPATLAHIR, karyawan.getTempat_lahir());
        values.put(COLUMN_JABATAN, karyawan.getJabatan());
        values.put(COLUMN_JENISKL, karyawan.getJenis_kl());
        values.put(COLUMN_EMAIL, karyawan.getEmail());
        values.put(COLUMN_PASSWORD, karyawan.getPassword());

        db.insert(TABLE_KARYAWAN, null, values);
        db.close();
    }

    // FUNGSI UNTUK AMBIL 1 DATA MAHASISWA
    public Karyawan getKaryawan(int id_karyawan) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_KARYAWAN, new String[]{COLUMN_ID, COLUMN_NAMA, COLUMN_TEMPATLAHIR, COLUMN_JABATAN, COLUMN_JENISKL, COLUMN_EMAIL, COLUMN_PASSWORD},
                COLUMN_ID + "=?", new String[]{String.valueOf(id_karyawan)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Karyawan karyawan = new Karyawan(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        return karyawan;
    }

    // FUNGSI UNTUK AMBIL SEMUA DATA MAHASISWA
    public List <Karyawan> getSemuaKaryawan() {
        List <Karyawan> karyawanList = new ArrayList <>();
        String selectQuery = "SELECT * FROM " + TABLE_KARYAWAN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Karyawan karyawan = new Karyawan(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                karyawanList.add(karyawan);
            } while (cursor.moveToNext());
        }
        return karyawanList;
    }

    // FUNGSI MENGHITUNG ADA BEBERAPA DATA
    public int getKaryawanCount() {
        String countQuery = "SELECT * FROM " + TABLE_KARYAWAN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // FUNGSI UPDATE DATA MAHASISWA
    public int updateDataKaryawan(Karyawan karyawan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA, karyawan.getNama());
        values.put(COLUMN_TEMPATLAHIR, karyawan.getTempat_lahir());
        values.put(COLUMN_JABATAN, karyawan.getJabatan());
        values.put(COLUMN_JENISKL, karyawan.getJenis_kl());
        values.put(COLUMN_EMAIL, karyawan.getEmail());
        values.put(COLUMN_PASSWORD, karyawan.getPassword());
        return db.update(TABLE_KARYAWAN, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(karyawan.getId())});
    }

    // FUNGSI HAPUS DATA 1 MAHASISWA
    public void hapusDataKaryawan(Karyawan karyawan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_KARYAWAN, COLUMN_ID + " = ?",
                new String[]{String.valueOf(karyawan.getId())});
        db.close();
    }

    // FUNGSI UNTUK MENGHAPUS SEMUA DATA MAHASISWA
    public void hapusSemuaDataKaryawan() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_KARYAWAN);
    }

    // FUNGSI LOGIN APLIKASI
    public Boolean checkusernamepassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from TABLE_KARYAWAN where email = ? and password = ?", new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    // FUNGSI MENGAMBIL DATA EMAIL
    public Boolean checkusername(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from TABLE_KARYAWAN where email = ? ", new String[] {email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    // FUNGSI RESET DAN UPDATE PASSWORD
    public Boolean updatepassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password",password);
        long result = db.update("table_karyawan", values, "email = ?", new String[] {email});
        if (result==-1) return false;
        else
            return true;
    }
}