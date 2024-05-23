package com.example.gongu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class pay extends AppCompatActivity {
    private Button ButtonToQR;
    private Button ButtonToMap;
    private Button ButtonToMypage;
    private ImageView imageview_QR;
    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        ButtonToQR = (Button) findViewById(R.id.button_temp_qr);
        ButtonToMap = (Button) findViewById(R.id.button_temp_map);
        ButtonToMypage = (Button) findViewById(R.id.button_temp_mypage);

        // MainActivity의 Fragment_qr로 이동
        ButtonToQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("fragment", "qr");
                startActivity(intent);
            }
        });

        // MainActivity의 Fragment_map로 이동
        ButtonToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("fragment", "map");
                startActivity(intent);
            }
        });

        // MainActivity의 Fragment_mypage로 이동
        ButtonToMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("fragment", "mypage");
                startActivity(intent);
            }
        });


        // imageview_QR = (ImageView)findViewById(R.id.imageview_QR);
        text = "QR코드 발급 완료";

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imageview_QR.setImageBitmap(bitmap);
        } catch(Exception e) {}

    }


}