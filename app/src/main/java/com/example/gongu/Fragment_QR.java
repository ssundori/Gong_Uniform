package com.example.gongu;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment_QR extends Fragment {

    public Fragment_QR() {
        // Required empty public constructor
    }

    private View view;
    private ImageButton button_qr_QR1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_qr, container, false);
        button_qr_QR1 = view.findViewById(R.id.button_qr_QR1);

        // 클릭 이벤트 핸들러 등록
        button_qr_QR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQRpopup();
            }
        });

        return view;
    }

    private void showQRpopup() {
        qrpopup dialog = new qrpopup(requireContext());
        dialog.show();
    }

}
