package com.example.gongu;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class pay extends AppCompatActivity {
    private Button createQRBtn;
    private Button toMapFragment;
    private Button ButtonToMap;
    private Button ButtonToMypage;
    private ImageView imageview_QR;
    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        createQRBtn = (Button) findViewById(R.id.button_temp_qr);
        toMapFragment = (Button) findViewById(R.id.button_temp_map);
        ButtonToMap = (Button) findViewById(R.id.button_temp_map);
        ButtonToMypage = (Button) findViewById(R.id.button_temp_mypage);

        //페이지 넘기기
        /*createQRBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(pay.this, CreateQR.class);
                startActivity(intent);
            }
        });*/

        imageview_QR = (ImageView)findViewById(R.id.imageview_QR);
        text = "QR코드 발급 완료";

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imageview_QR.setImageBitmap(bitmap);
        } catch(Exception e) {}

        /*ButtonToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Fragment_map.class);
                startActivity(intent);
            }
        });*/

        /*ButtonToMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Fragment_mypage.class);
                startActivity(intent);
            }
        });*/

    }


}