package com.example.gongu;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_rent_size#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_rent_size extends Fragment {
    //private SharedViewModel QRViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_rent_size() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_rent_size.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_rent_size newInstance(String param1, String param2) {
        Fragment_rent_size fragment = new Fragment_rent_size();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //QRViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    public void generateQRCode(ImageView qrView) {
        QRCodeWriter qrCode = new QRCodeWriter();
        try {
            // QR코드 생성 및 BitMatrix로 변환
            BitMatrix bitMtx = qrCode.encode(
                    getActivity().getIntent().getStringExtra("id"),
                    BarcodeFormat.QR_CODE, 350, 350
            );
            //BitMatrix를 Bitmap으로 변환하여 QR코드 이미지 생성
            Bitmap bitmap = Bitmap.createBitmap(bitMtx.getWidth(),bitMtx.getHeight(), Bitmap.Config.RGB_565);
            for (int i=0; i<bitMtx.getWidth(); i++) {
                for (int j=0; j<bitMtx.getHeight(); j++) {
                    int color;
                    if (bitMtx.get(i,j)) {
                        color = Color.BLACK;
                    } else {
                        color = Color.WHITE;
                    }
                    bitmap.setPixel(i,j,color);
                }
            }
            qrView.setImageBitmap(bitmap); // QR 코드 이미지를 ImageView에 설정하여 화면에 표시
            } catch (WriterException e) {
            e.printStackTrace();
        }

    }
    Button generateQRButton = getView().findViewById(R.id.button_temp_qr);
    ImageView qrImageView = getView().findViewById(R.id.QRImageView);

    //임시 qr 생성 버튼 클릭시 QR 생성
    /*generateQRButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            generateQRCode(qrImageView);
        }
    });*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rent_size, container, false);
    }
}