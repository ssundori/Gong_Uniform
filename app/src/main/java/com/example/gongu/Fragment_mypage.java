package com.example.gongu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Fragment_mypage extends Fragment {

    public Fragment_mypage() {
        // Required empty public constructor
    }

    private View view;
    private ImageButton button_qr_mypage1;
    TextView txt_date;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage, container, false);
        button_qr_mypage1 = view.findViewById(R.id.button_qr_mypage1);

        // 현재 시간 가져오기
        Date now = new Date();

        // 출력 포맷 정의
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        // 현재 시간을 텍스트뷰에 설정
        txt_date = view.findViewById(R.id.txt_date);
        txt_date.setText("주문 시각: \n" + sdf.format(now));

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
