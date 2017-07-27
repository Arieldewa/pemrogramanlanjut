package com.example.ariel.pemrogramanlanjut;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ariel.pemrogramanlanjut.adapter.univAdapter;
import com.example.ariel.pemrogramanlanjut.helper.myItem;
import com.example.ariel.pemrogramanlanjut.object.Universitas;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements AdapterView.OnItemClickListener,OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<Universitas> datauniv= new ArrayList<>();
    private ListView lv;
    private ClusterManager<myItem> mClusterManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        lv = (ListView) findViewById(R.id.lv);
        lv.setSelected(true);
        datauniv.add(new Universitas("Pens",new LatLng(-7.276764,112.794904)));
        datauniv.add(new Universitas("Unair",new LatLng(-7.272283,112.758034)));
        datauniv.add(new Universitas("Unesa",new LatLng(-7.300921,112.669484)));
        datauniv.add(new Universitas("ITS",new LatLng(-7.281865,112.794416)));
        univAdapter adapter = new univAdapter(this,datauniv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sub = new LatLng(-7.257472, 112.752088);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sub, 11.0f));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-7.276764, 112.794904), 10));
        mClusterManager = new ClusterManager<myItem>(this, mMap);
        mMap.setOnCameraIdleListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
        addItems();
    }

    private void addItems() {

        // Set some lat/lng coordinates to start with.
        double lat = -7.276764;
        double lng = 112.794904;

        // Add ten cluster items in close proximity, for purposes of this example.
        for (int i = 0; i < 10; i++) {
            double offset = i / 60d;
            lat = lat + offset;
            lng = lng + offset;
            myItem offsetItem = new myItem(lat, lng);
            mClusterManager.addItem(offsetItem);
        }

        lat = -7.116764;
        lng = 112.654904;

        for (int i = 0; i < 5; i++) {
            double offset = i / 60d;
            lat = lat + offset;
            lng = lng + offset;
            myItem offsetItem = new myItem(lat, lng);
            mClusterManager.addItem(offsetItem);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        mMap.addMarker(new MarkerOptions().position(datauniv.get(i).getLatLng()).title(datauniv.get(i).getUniv()));
        //String item = (String) parent.getItemAtPosition(key);
        myItem offsetItem = new myItem(datauniv.get(i).getLatLng().latitude,datauniv.get(i).getLatLng().longitude);
        mClusterManager.addItem(offsetItem);
    }
}
