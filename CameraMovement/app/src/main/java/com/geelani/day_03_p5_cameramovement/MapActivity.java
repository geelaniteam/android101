package com.geelani.day_03_p5_cameramovement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
public class MapActivity extends AppCompatActivity
        implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private Marker marker1;
    private Marker marker2;
    private LatLng Hyderbad = new LatLng(17.3850, 77.5946);
    private LatLng Delhi = new LatLng(28.7041, 77.1025);
    private GoogleMap mMap;

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
        mMap = googleMap;
        //setting onclick listeners for markers
        googleMap.setOnMarkerClickListener(this);

        MarkerOptions options = new MarkerOptions();
        options.position(Hyderbad)
                .title("Hyderabad")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        marker1 = mMap.addMarker(options);


        options.position(Delhi)
                .title("Delhi")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));

        marker2 = mMap.addMarker(options);

        //zoom the map within bounds
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(20.5937, 78.9629), 4.0f));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(marker1)) {
            moveCamera(Delhi);
            return true;
        } else if(marker.equals(marker2)) {
            moveCamera(Hyderbad);
            return true;
        }
        return false;
    }

    private void moveCamera(LatLng latLng) {
        //moving camera from one point to another point
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5));
    }
}
