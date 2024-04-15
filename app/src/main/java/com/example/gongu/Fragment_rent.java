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

public class Fragment_rent extends Fragment {

    private View view;
    private Button RtoRUButton;
    private ImageButton Button_selectGackbin;
    private ImageButton Button_selectKimjaehwan;
    private ImageButton Button_selectKimtaekyeon;
    private ImageButton Button_selectParkchikook;
    private TextView txt_selectedPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rent, container, false);
        RtoRUButton = view.findViewById(R.id.rtoru);
        Button_selectGackbin = view.findViewById(R.id.Button_selectGackbin);
        Button_selectKimjaehwan = view.findViewById(R.id.Button_selectKimjaehwan);
        Button_selectKimtaekyeon = view.findViewById(R.id.Button_selectKimtaekyeon);
        Button_selectParkchikook = view.findViewById(R.id.Button_selectParkchikook);
        txt_selectedPlayer = view.findViewById(R.id.txt_selectedPlayer); // txt_selectedPlayer 초기화
        RtoRUButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment_rent_uniform fragmentRentUniform = new Fragment_rent_uniform();

                transaction.replace(R.id.container, fragmentRentUniform);

                transaction.commit();
            }
        });

        Button_selectGackbin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_selectedPlayer.setText("곽빈");
            }
        });

        Button_selectKimjaehwan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_selectedPlayer.setText("김재환");
            }
        });

        Button_selectKimtaekyeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_selectedPlayer.setText("김택연");
            }
        });

        Button_selectParkchikook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_selectedPlayer.setText("박치국");
            }
        });

        return view;
    }


}
