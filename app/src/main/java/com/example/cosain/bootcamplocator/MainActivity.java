package com.example.cosain.bootcamplocator;

import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity  implements OnMapReadyCallback {

    private GoogleMap mMap;
    private EditText code;
    private Button ok;
    private List<Recycler> campList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BootCampAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        code = (EditText) findViewById(R.id.searchView1);
        ok = (Button) findViewById(R.id.button);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view) ;

        mAdapter = new BootCampAdapter(campList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String i = code.getText().toString().trim();
                int value = Integer.parseInt(i);

                if(value == 6000){
                    bootCamp();
                }

            }
        });



    }

    private void bootCamp(){

     Recycler camps = new Recycler("   Usjr TESDA Building","    Basak Pardo Cebu City,Cebu" ,R.drawable.img );
        campList.add(camps);

        camps = new Recycler("   Don Bosco Technological Center","    Punta Princesa, Cebu City,Cebu",R.drawable.img);
        campList.add(camps);
        camps = new Recycler("   Archdiocesan Shrine of Our Lady of Lourdes","    Punta Princesa, Cebu City, Cebu",R.drawable.img);
        campList.add(camps);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng cur = new LatLng(10.294159,123.86581);
        MarkerOptions marker = new MarkerOptions().position(new LatLng(10.2895433, 123.8633644)).title("current location");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cur));

        MarkerOptions markerUsjr = new MarkerOptions().position(new LatLng(10.291162, 123.8606264)).title("Usjr TESDA Building");
        markerUsjr.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin));
        mMap.addMarker(markerUsjr);

        MarkerOptions markerDon = new MarkerOptions().position(new LatLng(10.2968258, 123.8609882)).title("Don Bosco Technological Center");
        markerDon.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin));
        mMap.addMarker(markerDon);

        MarkerOptions markerChurch = new MarkerOptions().position(new LatLng(10.2935162, 123.8674853)).title("Archdiocesan Shrine of Our Lady of Lourdes");
        markerChurch.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin));
        mMap.addMarker(markerChurch);

    }

    private String getAddressFromLatLng(LatLng latLng) {
        Geocoder geocoder = new Geocoder(this);
        String address = "";
        try {
            address = geocoder
                    .getFromLocation(10.291162, 123.8606264, 1)
                    .get(0).getAddressLine(0);
        } catch (IOException e) {
        }
        return address;

    }
}


