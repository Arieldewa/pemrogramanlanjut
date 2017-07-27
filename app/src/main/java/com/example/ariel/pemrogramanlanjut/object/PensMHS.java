package com.example.ariel.pemrogramanlanjut.object;

import java.io.Serializable;

/**
 * Created by Ariel on 5/12/2017.
 */

public class PensMHS implements Serializable{
    private int nrp;
    private String name;
    private String jurusan;

    public PensMHS(int nrp, String name, String jurusan) {
        this.nrp = nrp;
        this.name = name;
        this.jurusan = jurusan;
    }

    public PensMHS() {

    }

    public int getNrp() {
        return nrp;
    }

    public void setNrp(int nrp) {
        this.nrp = nrp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}
