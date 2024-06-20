package com.example.gongu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.LinearLayout;
import android.widget.TextView;

// 화면 전환을 위함 import 추가
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.gongu.retrofit.RetrofitService;
import com.example.gongu.retrofit.UserAPI;
import com.google.android.material.textfield.TextInputEditText;

public class login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 입력한 텍스트 가져오기
        TextInputEditText loginEmail = findViewById(R.id.EmailInsert);
        TextInputEditText loginPassword = findViewById(R.id.PasswordInsert);

        Button imageButton = (Button) findViewById(R.id.LoginBtn);

        // Retrofit, UserAPI
        RetrofitService retrofit = new RetrofitService();
        UserAPI userapi = retrofit.getRetrofit().create(UserAPI.class);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button signupButton = (Button) findViewById(R.id.text_view_sign_up);
        signupButton.setOnClickListener(new View.OnClickListener() {

            String email = String.valueOf(loginEmail.getText());
            String password = String.valueOf(loginPassword.getText());

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), signup.class);
                startActivity(intent);
            }
        });
    }
}

