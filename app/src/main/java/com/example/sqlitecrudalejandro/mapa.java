package com.example.sqlitecrudalejandro;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.HashMap;

public class mapa extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    GoogleMap mMap;
    private HashMap<String, Integer> videoMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);

        // Agrega tus marcadores
        addMarker(-35.42798673115764, -71.67313790230351, "Veterinaria Talca");
        addMarker(-38.734672742952945, -72.60196170920258, "Veterinaria Temuco");

        // Mueve la cámara al final de agregar los marcadores
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-41.47202433629501, -72.92876244096891)));
    }

    private void addMarker(double lat, double lng, String title) {
        LatLng location = new LatLng(lat, lng);
        Marker marker = mMap.addMarker(new MarkerOptions().position(location).title(title));
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        // Implementa la lógica para manejar el clic en el marcador aquí
        return false;  // Devuelve true si consumes el evento, false de lo contrario
    }
}
