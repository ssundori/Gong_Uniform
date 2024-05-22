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
    public static final int REQUEST_CODE_NEXT = 101;
    TextView textView;
    Button button;
    Fragment_rent fragmentRent;
    Fragment_map fragmentMap;
    Fragment_home fragmentHome;
    Fragment_QR fragmentQR;
    Fragment_mypage fragmentMyPage;

    Fragment_rent_uniform fragmentRentUniform;
    Fragment_rent_size fragmentRentSize;

    //Fragment selected = null;
    Bundle mBundle; //main bundle


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentRent = new Fragment_rent();
        fragmentMap = new Fragment_map();
        fragmentHome = new Fragment_home();
        fragmentQR = new Fragment_QR();
        fragmentMyPage = new Fragment_mypage();

        fragmentRentSize = new Fragment_rent_size();
        fragmentRentUniform = new Fragment_rent_uniform();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);

        // 특정 Frangment 화면으로 이동하고 싶을 때
        String fragmentToLoad = getIntent().getStringExtra("fragment");
        if(fragmentToLoad != null && fragmentToLoad.equals("rent")){ // 대여 화면으로 가고 싶을 경우
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentRent).commit();
            bottomNavigation.setSelectedItemId(R.id.tab1);
        }else if (fragmentToLoad != null && fragmentToLoad.equals("map")) { // 지도 화면으로 가고 싶을 경우
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMap).commit();
            bottomNavigation.setSelectedItemId(R.id.tab2);
        }else if (fragmentToLoad != null && fragmentToLoad.equals("qr")) { // QR 화면으로 가고 싶을 경우
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentQR).commit();
            bottomNavigation.setSelectedItemId(R.id.tab4);
        }else if (fragmentToLoad != null && fragmentToLoad.equals("mypage")) { // 마이페이지 화면으로 가고 싶을 경우
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMyPage).commit();
            bottomNavigation.setSelectedItemId(R.id.tab5);
        }else{
            // 홈화면으로 초기 설정
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();
            bottomNavigation.setSelectedItemId(R.id.tab3);
        }

        bottomNavigation.setOnItemSelectedListener(
                new BottomNavigationView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        if (item.getItemId() == R.id.tab1) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentRent).commit();
                            return true;
                        } else if (item.getItemId() == R.id.tab2) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMap).commit();
                            return true;
                        } else if (item.getItemId() == R.id.tab3) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();
                            return true;
                        } else if (item.getItemId() == R.id.tab4) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentQR).commit();
                            return true;
                        } else if (item.getItemId() == R.id.tab5) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMyPage).commit();
                            return true;
                        }
                        return false;
                    }

                }
        );

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

    }

}
