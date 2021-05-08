package com.example.hendryansha;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.location_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //  tambah koordinat marker
        LatLng user = new LatLng (-0.951331, 119.918691);
        LatLng bandara = new LatLng(-0.918627, 119.906324);

//    atur ukuran marker
        int tinggi = 100;
        int lebar = 100;

        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.ian);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.garuda);

        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();

        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

//    tambahkan marker ke map
        mMap.addMarker(new MarkerOptions().position(user).title("Marker in UNTAD")
                .snippet("Ini Kampus Panas")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(bandara).title("Marker in WALKOT")
                .snippet("Ini Walkot Dong")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));


        mMap.addPolyline(new PolylineOptions().add(
                user,
                new LatLng(-0.951331, 119.918691),
                new LatLng(-0.950557, 119.916795),
                new LatLng(-0.948092, 119.912007),
                new LatLng(-0.944509, 119.905624),
                new LatLng(-0.942205, 119.901619),
                new LatLng(-0.941056, 119.901509),
                new LatLng(-0.938460, 119.900629),
                new LatLng(-0.935993, 119.899524),
                new LatLng(-0.931605, 119.897764),
                new LatLng(-0.927175, 119.895956),
                new LatLng(-0.924220, 119.895135),
                new LatLng(-0.922064, 119.894051),
                new LatLng(-0.920820, 119.893692),
                new LatLng(-0.918793, 119.892635),
                new LatLng(-0.918643, 119.893821),
                new LatLng(-0.919120, 119.895527),
                new LatLng(-0.919136, 119.898858),
                new LatLng(-0.918970, 119.903627),
                new LatLng(-0.918455, 119.904700),
                new LatLng(-0.917838, 119.905226),
                new LatLng(-0.917895, 119.905660),
                new LatLng(-0.917900, 119.905995),
                new LatLng(-0.918627, 119.906324),
                bandara
        ).width(10)
                .color(Color.BLACK));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(user, 11.5f));
    }
}