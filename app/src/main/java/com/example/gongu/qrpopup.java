package com.example.gongu;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class qrpopup extends AppCompatActivity {

    private ImageView qrimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrpopup);

    }

    public void mOnClose(View v) {

        //팝업 닫기
        finish();
    }
}