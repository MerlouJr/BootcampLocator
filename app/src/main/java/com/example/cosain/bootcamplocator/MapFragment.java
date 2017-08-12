package com.example.cosain.bootcamplocator;

import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by cosain on 8/11/2017.
 */

public class MapFragment extends SupportMapFragment implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnInfoWindowClickListener,
        GoogleMap.OnMapLongClickListener,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMarkerClickListener {


    private GoogleApiClient mGoogleApiClient;
    private Location mCurrentLocation;


    private final int[] MAP_TYPES = {
            GoogleMap.MAP_TYPE_SATELLITE,
            GoogleMap.MAP_TYPE_NORMAL,
            GoogleMap.MAP_TYPE_HYBRID,
            GoogleMap.MAP_TYPE_TERRAIN,
            GoogleMap.MAP_TYPE_NONE
    };
    private int curMapTypeIndex = 0;


//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        setHasOptionsMenu(true);
//
//        mGoogleApiClient = new GoogleApiClient.Builder( getActivity() )
//                .addConnectionCallbacks( this )
//                .addOnConnectionFailedListener( this )
//                .addApi( LocationServices.API )
//                .build();
//
//        initListeners();
//    }

    @Override
    public void onConnected(Bundle bundle) {
//        mCurrentLocation = LocationServices
//                .FusedLocationApi
//                .getLastLocation( mGoogleApiClient );
//        initCamera( mCurrentLocation );
    }
//    private void initListeners() {
//        getMap().setOnMarkerClickListener(this);
//        getMap().setOnMapLongClickListener(this);
//        getMap().setOnInfoWindowClickListener( this );
//        getMap().setOnMapClickListener(this);
//    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {
//        MarkerOptions options = new MarkerOptions().position( latLng );
//        options.title( getAddressFromLatLng( latLng ) );
//
//        options.icon( BitmapDescriptorFactory.fromBitmap(
//                BitmapFactory.decodeResource( getResources(),
//                        R.mipmap.ic_launcher ) ) );
//        getMap().addMarker( options );
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        return true;

    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        mGoogleApiClient.connect();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if( mGoogleApiClient != null && mGoogleApiClient.isConnected() ) {
//            mGoogleApiClient.disconnect();
//        }
//    }
//
//    private String getAddressFromLatLng( LatLng latLng ) {
//        Geocoder geocoder = new Geocoder( getActivity() );
//        String address = "";
//        try {
//            address = geocoder
//                    .getFromLocation( latLng.latitude, latLng.longitude, 1 )
//                    .get( 0 ).getAddressLine( 0 );
//        } catch (IOException e ) {
//        }
//
//        return address;
//    }
//
//    private void initCamera( Location location ) {
//        CameraPosition position = CameraPosition.builder()
//                .target( new LatLng( location.getLatitude(),location.getLongitude() ) )
//                .zoom( 16f )
//                .bearing( 0.0f )
//                .tilt( 0.0f )
//                .build();
//        getMap().animateCamera( CameraUpdateFactory
//                .newCameraPosition( position ), null );
//        getMap().setMapType( MAP_TYPES[curMapTypeIndex] );
//        getMap().setTrafficEnabled( true );
//        getMap().setMyLocationEnabled( true );
//        getMap().getUiSettings().setZoomControlsEnabled( true );
//    }

}
