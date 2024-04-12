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
    private ImageView imageview_QR;
    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        createQRBtn = (Button) findViewById(R.id.button_temp_qr);
        toMapFragment = (Button) findViewById(R.id.button_temp_map);

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

    }
}