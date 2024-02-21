package com.example.gongu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

//inflater  처리 안됨

public class activity_select_player extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player);

        container = findViewById(R.id.container);

        Button button = findViewById(R.id.button);
        button.setOnclickListener(new View.OnClickListener() {
            @override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT+INFLATER_SERVICE);
                inflater.inflate(R.layout.sub_player, container, true);
            }
        });

    }
}