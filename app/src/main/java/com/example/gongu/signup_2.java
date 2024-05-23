package com.example.gongu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gongu.model.User;
import com.example.gongu.retrofit.RetrofitService;
import com.example.gongu.retrofit.UserAPI;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signup_2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_2);

        // 입력한 텍스트 가져오기
        TextInputEditText Name = findViewById(R.id.SignUpName);
        TextInputEditText Email = findViewById(R.id.SignUpEmail);
        TextInputEditText Password = findViewById(R.id.SignUpPassword);
        TextInputEditText Account = findViewById(R.id.SignUpAccount);

        Button TeamSurvey = findViewById(R.id.SignUpSelectTeamSurvey);

        TeamSurvey.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), select_team.class);
                startActivity(intent);
            }
        });

        // Sign up 버튼
        Button createUserButton = findViewById(R.id.createUserBtn);

        // 입력 후 Sign up 버튼 누르면
        createUserButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });
    }
}
