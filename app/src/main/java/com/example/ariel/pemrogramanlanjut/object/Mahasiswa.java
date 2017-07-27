package com.example.ariel.pemrogramanlanjut.object;

/**
 * Created by Ariel on 3/27/2017.
 */

public class Mahasiswa {
    private String nama,alamat;
    private int nrp,img;

    public Mahasiswa(String nama, String alamat, int nrp, int img) {
        this.nama = nama;
        this.alamat = alamat;
        this.nrp = nrp;
        this.img = img;
    }

    public Mahasiswa() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getNrp() {
        return nrp;
    }

    public void setNrp(int nrp) {
        this.nrp = nrp;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
