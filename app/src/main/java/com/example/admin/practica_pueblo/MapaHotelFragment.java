package com.example.admin.practica_pueblo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapaHotelFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;

    public MapaHotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mapa_hotel, container, false);

        mapView = (MapView) view.findViewById(R.id.map2);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);

        // Inflate the layout for this fragment
        return view;


    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //tipo de mapaç

        // Add a marker in Sydney and move the camera
        LatLng Rest1 = new LatLng(6.063872882778393,-75.79499691724777);
        mMap.addMarker(new MarkerOptions().position(Rest1).title("Hotel Sara y B"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Rest1, 16));

        LatLng Rest2 = new LatLng(6.062950030309811,-75.79497545957565);
        mMap.addMarker(new MarkerOptions().position(Rest2).title("Hotel Titiribi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Rest2, 16));

        LatLng Rest3 = new LatLng(6.063654172220497,-75.79345732927322);
        mMap.addMarker(new MarkerOptions().position(Rest3).title("Residencias y Restaurante Alaska"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Rest3, 16));








    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();

    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }
}
