package com.sandbox.myattendance;

public class Karyawan {

    private int id;
    private String nama;
    private String tempat_lahir;
    private String jabatan;
    private String jenis_kl;
    private String email;
    private String password;

    public Karyawan() {
    }

    public Karyawan(String nama, String tempat_lahir, String jabatan, String jenis_kl, String email, String password) {
        this.nama = nama;
        this.tempat_lahir = tempat_lahir;
        this.jabatan = jabatan;
        this.jenis_kl = jenis_kl;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getJenis_kl() {
        return jenis_kl;
    }

    public void setJenis_kl(String jenis_kl) {
        this.jenis_kl = jenis_kl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
