package com.example.gongu;

import android.content.Intent;
import android.os.Bundle;
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

public class signup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // 입력한 텍스트 가져오기
        TextInputEditText Name = findViewById(R.id.SignUpName);
        TextInputEditText Email = findViewById(R.id.SignUpEmail);
        TextInputEditText Password = findViewById(R.id.SignUpPassword);
        TextInputEditText SelectedTeam = findViewById(R.id.SignUpSelectedTeam);
        TextInputEditText Account = findViewById(R.id.SignUpAccount);

        // Sign up 버튼
        Button createUserButton = findViewById(R.id.createUserBtn);

        // Retrofit, UserAPI
        RetrofitService retrofit = new RetrofitService();
        UserAPI userapi = retrofit.getRetrofit().create(UserAPI.class);

        // 입력 후 Sign up 버튼 누르면
        createUserButton.setOnClickListener(view -> {
            String name = String.valueOf(Name.getText());
            String email = String.valueOf(Email.getText());
            String password = String.valueOf(Password.getText());
            String selectedteam = String.valueOf(SelectedTeam.getText());
            String account = String.valueOf(Account.getText());

            // 생성할 User
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setSelectedteam(selectedteam);
            user.setAccount(account);

            // Post API
            userapi.get(user)
                    .enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) { // 성공
                            Toast.makeText(signup.this, "Save Success", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), select_team.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) { // 실패
                            Toast.makeText(signup.this, "Save failed", Toast.LENGTH_LONG).show();
                            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });

        });
    }
}
