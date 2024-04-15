package com.example.gongu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
public class Fragment_rent_uniform extends Fragment {

    private View view;
    private Button RUtoRS;
    private ImageButton Button_uniformHome;
    private ImageButton Button_uniformAway;
    private ImageButton Button_uniformMilitary;
    private ImageButton Button_uniformOldhome;
    private TextView txt_selectedUniform;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rent_uniform, container, false);
        RUtoRS = view.findViewById(R.id.rutors);
        Button_uniformHome = view.findViewById(R.id.Button_uniformHome);
        Button_uniformAway = view.findViewById(R.id.Button_uniformAway);
        Button_uniformMilitary = view.findViewById(R.id.Button_uniformMilitary);
        Button_uniformOldhome = view.findViewById(R.id.Button_uniformOldhome);
        txt_selectedUniform = view.findViewById(R.id.txt_selectedUniform);


        Button_uniformHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_selectedUniform.setText("홈");
            }
        });

        Button_uniformAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_selectedUniform.setText("어웨이");
            }
        });
        
        Button_uniformMilitary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_selectedUniform.setText("밀리터리");
            }
        });

        Button_uniformOldhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_selectedUniform.setText("올드 홈");
            }
        });
        
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

    public void setText(String text) {
        txt_selectedUniform.setText(text);
    }
}