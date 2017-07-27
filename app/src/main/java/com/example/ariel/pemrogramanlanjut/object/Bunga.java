package com.example.ariel.pemrogramanlanjut.object;

/**
 * Created by Ariel on 4/14/2017.
 */

public class Bunga {
    private String bunga;
    private int pict;

    public Bunga() {
    }

    public Bunga(String bunga, int pict) {
        this.bunga = bunga;
        this.pict = pict;
    }

    public String getBunga() {
        return bunga;
    }

    public void setBunga(String bunga) {
        this.bunga = bunga;
    }

    public int getPict() {
        return pict;
    }

    public void setPict(int pict) {
        this.pict = pict;
    }
}
