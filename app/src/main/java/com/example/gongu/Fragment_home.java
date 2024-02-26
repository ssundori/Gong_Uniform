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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Fragment_home extends Fragment {

    // 대여 버튼도 있으니 view로 전달
    private View view;
    private Button GoRentBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        GoRentBtn = view.findViewById(R.id.HomeToRentBtn);
        GoRentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment_rent fragmentRent = new Fragment_rent();
                transaction.replace(R.id.container, fragmentRent);
                transaction.commit();
            }
        });
        return view;
    }
}
