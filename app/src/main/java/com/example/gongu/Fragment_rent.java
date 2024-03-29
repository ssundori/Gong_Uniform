package com.example.gongu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment_rent extends Fragment {

    private View view;
    private Button RtoRUButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rent, container, false);
        RtoRUButton = view.findViewById(R.id.rtoru);
        RtoRUButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment_rent_uniform fragmentRentUniform = new Fragment_rent_uniform();

                transaction.replace(R.id.container, fragmentRentUniform);

                transaction.commit();
            }
        });
        return view;
    }

}
