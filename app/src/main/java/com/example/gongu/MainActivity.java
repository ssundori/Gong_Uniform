package com.example.gongu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;






import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Fragment_rent fragmentRent;
    Fragment_map fragmentMap;
    Fragment_home fragmentHome;
    Fragment_QR fragmentQR;
    Fragment_mypage fragmentMyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentRent = new Fragment_rent();
        fragmentMap = new Fragment_map();
        fragmentHome = new Fragment_home();
        fragmentQR = new Fragment_QR();
        fragmentMyPage = new Fragment_mypage();



        //네비게이션 바
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentRent).commit();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        if (item.getItemId() == R.id.tab1) {
                            Toast.makeText(getApplicationContext(), "대여 페이지 선택됨", Toast.LENGTH_LONG).show();
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentRent).commit();
                            return true;
                        } else if (item.getItemId() == R.id.tab2) {
                            Toast.makeText(getApplicationContext(), "QR 페이지 선택됨", Toast.LENGTH_LONG).show();
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMap).commit();
                            return true;
                        } else if (item.getItemId() == R.id.tab3) {
                            Toast.makeText(getApplicationContext(), "홈 페이지 선택됨", Toast.LENGTH_LONG).show();
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();
                            return true;
                        } else if (item.getItemId() == R.id.tab4) {
                            Toast.makeText(getApplicationContext(), "QR 페이지 선택됨", Toast.LENGTH_LONG).show();
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentQR).commit();
                            return true;
                        } else if (item.getItemId() == R.id.tab5) {
                            Toast.makeText(getApplicationContext(), "마이 페이지 선택됨", Toast.LENGTH_LONG).show();
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMyPage).commit();
                            return true;
                        }
                        return false;
                    }

                }
        );




        //지도 페이지
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLocationService();
            }
        });

        public void onTabSelected(int position){
            if (position == 0) {
                bottomNavigation.setSelectedItemId(R.id.tab1);
            } else if (position == 1) {
                bottomNavigation.setSelectedItemId(R.id.tab2);
            } else if (position == 2) {
                bottomNavigation.setSelectedItemId(R.id.tab3);
            } else if (position == 3) {
                bottomNavigation.setSelectedItemId(R.id.tab4);
            } else if (position == 4) {
                bottomNavigation.setSelectedItemId(R.id.tab5);
            }
        }

    }

    public void startLocationService() {
        LocationManager manager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);

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
            Toast.makeText(getApplicationContext(), "내 위치확인 요청함", Toast.LENGTH_SHORT).show();
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
        }

        public void onProviderDisabled(String provider) { }
        public void onProviderEnabled(String provider) { }
        public void onStatusChanged(String provider, int status, Bundle extras) { }
    }
}