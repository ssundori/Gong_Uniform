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

public class Fragment_mypage extends Fragment {

    public Fragment_mypage() {
        // Required empty public constructor
    }

    private View view;
    private ImageButton button_qr_mypage1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage, container, false);
        button_qr_mypage1 = view.findViewById(R.id.button_qr_mypage1);

        // 클릭 이벤트 핸들러 등록
        button_qr_mypage1.setOnClickListener(new View.OnClickListener() {
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
