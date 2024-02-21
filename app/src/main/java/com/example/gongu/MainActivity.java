package com.example.gongu;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
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
                            Toast.makeText(getApplicationContext(), "지도 페이지 선택됨", Toast.LENGTH_LONG).show();
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

        button = findViewById(R.id.button);





    }



}