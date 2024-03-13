package com.example.gongu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
public class Fragment_rent_uniform extends Fragment {

    private View view;
    private Button RUtoRS;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rent_uniform, container, false);
        RUtoRS = view.findViewById(R.id.rutors);
        RUtoRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment_rent_size fragmentRentSize = new Fragment_rent_size();

                transaction.replace(R.id.container, fragmentRentSize);

                transaction.commit();
            }
        });
        return view;
    }
}