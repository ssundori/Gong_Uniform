package com.example.gongu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
    public static final int REQUEST_CODE_NEXT = 101;

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

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "버튼이 눌렸어요.",
                        Toast.LENGTH_LONG).show();
            }
        });

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), selectUniform.class);
                startActivity(intent);

            }
        });







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