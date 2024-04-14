package com.example.gongu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
// Button 추가
import android.widget.Button;

import androidx.fragment.app.Fragment;
// FragmentTransaction 추가
import androidx.fragment.app.FragmentTransaction;
// import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Fragment_home extends Fragment {

    // 대여 버튼이 있으니 view로 전달
    private View view;
    private Button GoRentBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        // 초기화한 view에서 GoRentBtn을 찾아서 초기화합니다.
        GoRentBtn = view.findViewById(R.id.HomeToRentBtn);
        GoRentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("fragment", "rent");
                startActivity(intent);
            }
        });

        return view;
    }
    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.fragment_home, container, false);

        view = inflater.inflate(R.layout.fragment_home, container, false);
        GoRentBtn = view.findViewById(R.id.HomeToRentBtn);
        GoRentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fragmentToLoad = "map"; // fragmentMap으로 이동할 것임을 나타냅니다.
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMap).commit();
            }
        });
        return view;
    }*/
}