package com.example.gongu;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qrpopup extends Dialog {

    private ImageView qrimage;
    private Button button_shutdown;

    public qrpopup(@NonNull Context context) {
        super(context);
        setContentView(R.layout.activity_qrpopup);
        qrimage = findViewById(R.id.imageview_QR_popup);
        button_shutdown = findViewById(R.id.button_shutdown);

        button_shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // QR 코드 생성
        generateQRCode("QR코드 발급 완료");
    }

    // QR 코드를 생성하고 ImageView에 표시하는 메서드
    private void generateQRCode(String content) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            qrimage.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}