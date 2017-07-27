package com.example.ariel.pemrogramanlanjut.object;

import com.google.android.gms.maps.model.LatLng;

import java.math.BigDecimal;

/**
 * Created by Ariel on 5/21/2017.
 */

public class Universitas {
    private String univ;
    private LatLng latLng;

    public Universitas(String univ, LatLng latLng) {
        this.univ = univ;
        this.latLng = latLng;
    }

    public Universitas() {
    }

    public String getUniv() {
        return univ;
    }

    public void setUniv(String univ) {
        this.univ = univ;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}
