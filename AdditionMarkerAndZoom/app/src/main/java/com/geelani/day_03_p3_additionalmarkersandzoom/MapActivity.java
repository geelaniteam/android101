package com.geelani.day_03_p3_additionalmarkersandzoom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
public class MapActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_map);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user receives a prompt to install
     * Play services inside the SupportMapFragment. The API invokes this method after the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {


        LatLng Hyderbad = new LatLng(17.3850, 77.5946);
        googleMap.addMarker(new MarkerOptions().position(Hyderbad).title("Hyderbad")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        LatLng Delhi = new LatLng(17.3850, 77.5946);
        googleMap.addMarker(new MarkerOptions().position(Delhi).title("Delhi")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));

        LatLng Pune = new LatLng(18.5204, 73.8567);
        googleMap.addMarker(new MarkerOptions().position(Pune).title("Pune")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        LatLng Chennai = new LatLng(13.0827, 80.2707);
        googleMap.addMarker(new MarkerOptions().position(Chennai).title("Chennai")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));

        LatLng Mumbai = new LatLng(19.0760, 72.8777);
        googleMap.addMarker(new MarkerOptions().position(Mumbai).title("Mumbai")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));

        LatLng Kolkata = new LatLng(22.5726, 88.3639);
        googleMap.addMarker(new MarkerOptions().position(Kolkata).title("Kolkata")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

        LatLng Ahmedabad = new LatLng(23.0225, 72.5714);
        googleMap.addMarker(new MarkerOptions().position(Ahmedabad).title("Ahmedabad")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

        //zoom the map within bounds
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(20.5937,78.9629),4.0f));
    }
}
