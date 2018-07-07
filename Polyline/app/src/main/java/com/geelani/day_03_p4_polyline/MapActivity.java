package com.geelani.day_03_p4_polyline;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

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
        googleMap.addMarker(new MarkerOptions().position(Hyderbad).title("Hyderbad")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

        LatLng Delhi = new LatLng(28.7041, 77.1025);
        googleMap.addMarker(new MarkerOptions().position(Delhi).title("Delhi")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));


        LatLng Kolkatta = new LatLng(22.5726, 88.3639);
        googleMap.addMarker(new MarkerOptions().position(Kolkatta).title("Kolkatta")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

        LatLng Chennai = new LatLng(13.0827, 80.2707);
        googleMap.addMarker(new MarkerOptions().position(Chennai).title("Chennai")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));



        //zoom the map within bounds
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(20.5937,78.9629),4.0f));



        //drawing polyline between 2 points
        // Add polylines and polygons to the map. This section shows just
        // a single polyline. Read the rest of the tutorial to learn more.
        Polyline line = googleMap.addPolyline(new PolylineOptions()
                .add(Hyderbad,Delhi)
                .width(5)
                .color(Color.RED));

        //Please comment above code and uncomment below code to draw polygone

//        Polygon polygon1 = googleMap.addPolygon(new PolygonOptions()
//                .strokeWidth(5)
//                .strokeColor(Color.RED)
//                        .add(Hyderbad,
//                        Delhi,
//                        Kolkatta,
//                       Chennai)
//                );

    }
}
