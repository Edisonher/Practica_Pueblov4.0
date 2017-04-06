package com.example.admin.practica_pueblo;


import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
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
public class MapaResFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;

    public MapaResFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mapa_res, container, false);

        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);

        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //tipo de mapaç

        // Add a marker in Sydney and move the camera
        LatLng Rest1 = new LatLng(6.062544614853368,-75.79356998205185);
        mMap.addMarker(new MarkerOptions().position(Rest1).title("El Gourmet de La Abuela Ines"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Rest1, 16));

        LatLng Rest2 = new LatLng(6.063078056180122,-75.79443901777267);
        mMap.addMarker(new MarkerOptions().position(Rest2).title("Restaurante Bar titiribi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Rest2, 16));

        LatLng Rest3 = new LatLng(6.0640115772325585,-75.79300671815872);
        mMap.addMarker(new MarkerOptions().position(Rest3).title("Restaurante la parrilla"));
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
