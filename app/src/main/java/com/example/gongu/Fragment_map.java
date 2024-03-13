package com.example.gongu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Fragment_map extends Fragment implements OnMapReadyCallback {
    TextView textView;
    Button button;
    View view;
    //TextView locationText;
    TextView addressText;
    Button locationButton;
    private GoogleMap mMap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.fragment_map, container, false);
        textView = view.findViewById(R.id.locationText);
        addressText = view.findViewById(R.id.addressText); // addressText 찾기
        button = view.findViewById(R.id.locationButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLocationService();
            }
        });

        new RequestPermissionsUtil(getContext()).requestLocation(); //위치 권한 요청

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }



    @Override
    public void onStart() {
        super.onStart();
    }

    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void startLocationService() {
        LocationManager manager= (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        try {
            Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                String message = "최근 위치 -> Latitude : " + latitude + "\nLongitude : " + longitude;

                textView.setText(message);
            }

            GPSListener gpsListener = new GPSListener();
            long minTime = 10000; //최소 시간 10초, 10초마다 위치 정보 전달받음
            float minDistance = 0; //최소 거리 설정

            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);
            Toast.makeText(getActivity().getApplicationContext(), "내 위치확인 요청함", Toast.LENGTH_SHORT).show();
        } catch(SecurityException e) {
            e.printStackTrace();
        }
    }


    class GPSListener implements LocationListener {
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();
            String message = "내 위치 -> Latitude : " + latitude + "\nLongitude : " + longitude;
            textView.setText(message);

            updateAddress(location); //위치 변경 시 주소 업데이트
        }

        public void onProviderDisabled(String provider) { }
        public void onProviderEnabled(String provider) { }
        public void onStatusChanged(String provider, int status, Bundle extras) { }
    }

    private void updateAddress(Location location) {
        List<Address> addresses = getAddress(getContext(), location.getLatitude(), location.getLongitude());
        if (addresses != null && !addresses.isEmpty()) {
            Address address = addresses.get(0);
            if (address != null) {
                String fullAddress = address.getAdminArea() + " " + address.getLocality() + " " + address.getThoroughfare();
                addressText.setText(fullAddress);
            }
        }
    }



    public class LocationHelper {
        private final Context context;
        public LocationHelper(Context context) {
            this.context = context;
        }


        @SuppressLint("MissingPermission")
        private void getLocation(final Context context) {
            FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location success) {
                            if (success != null) {
                                List<Address> addresses = getAddress(context, success.getLatitude(), success.getLongitude());
                                if (addresses != null && !addresses.isEmpty()) {
                                    Address address = addresses.get(0);
                                    if (address != null) {
                                        addressText.setText(address.getAdminArea() + " " + address.getLocality() + " " + address.getThoroughfare());
                                    }
                                }
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            textView.setText(e.getLocalizedMessage());
                        }
                    });
        }

    }
    private List<Address> getAddress(Context context, double lat, double lng) {
        List<Address> address = null;
        try {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
            address = geocoder.getFromLocation(lat, lng, 1);
        } catch (IOException e) {
            Toast.makeText(context, "주소를 가져올 수 없습니다", Toast.LENGTH_SHORT).show();
        }
        return address;
    }


    @SuppressLint("MissingPermission")
    private void getLocation(final Context context, final TextView textView, final TextView addressText) {
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location success) {
                        if (success != null) {
                            List<Address> addresses = getAddress(context, success.getLatitude(), success.getLongitude());
                            if (addresses != null && !addresses.isEmpty()) {
                                Address address = addresses.get(0);
                                if (address != null) {
                                    addressText.setText(address.getAdminArea() + " " + address.getLocality() + " " + address.getThoroughfare());
                                }
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        textView.setText(e.getLocalizedMessage());
                    }
                });
    }

    //NULL이 아닌 GoogleMap 객체를 파라미터로 제공해줄 수 있을 때 호출
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        LatLng SEOUL = new LatLng(37.556, 126.97);
        LatLng Jamsil1 = new LatLng(37.511881, 127.073653);

        MarkerOptions markerOptions = new MarkerOptions();
        MarkerOptions markerOptions2 = new MarkerOptions();

        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국 수도");

        markerOptions2.position(Jamsil1);
        markerOptions2.title("공유니폼 1호점");
        markerOptions2.snippet("대여, 반납 가능");

        mMap.addMarker(markerOptions);
        mMap.addMarker(markerOptions2);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL,10));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Jamsil1, 10));
    }



}