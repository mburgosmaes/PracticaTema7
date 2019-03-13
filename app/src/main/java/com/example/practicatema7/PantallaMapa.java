package com.example.practicatema7;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.practicatema7.Logic.LogicSitios;
import com.example.practicatema7.Model.Sitios;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class PantallaMapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng Marcador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private void mostrarMarcadores() {
        List<Sitios> listaLugares = LogicSitios.listaSitios(this);
        if (listaLugares == null) {
        } else {

            for (Sitios l : listaLugares) {
                Marcador = new LatLng(l.getLatitud(), l.getLongitud());
                if (l.getCategoria() == 1) {
                    mMap.addMarker(new MarkerOptions().position(Marcador).title(l.getNombre()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                } else if (l.getCategoria() == 2) {
                    mMap.addMarker(new MarkerOptions().position(Marcador).title(l.getNombre()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                } else if (l.getCategoria() == 3) {
                    mMap.addMarker(new MarkerOptions().position(Marcador).title(l.getNombre()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                } else if (l.getCategoria() == 4) {
                    mMap.addMarker(new MarkerOptions().position(Marcador).title(l.getNombre()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
                } else if (l.getCategoria() == 5) {
                    mMap.addMarker(new MarkerOptions().position(Marcador).title(l.getNombre()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                } else if (l.getCategoria() == 6) {
                    mMap.addMarker(new MarkerOptions().position(Marcador).title(l.getNombre()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                }
            }
        }
    }
}
