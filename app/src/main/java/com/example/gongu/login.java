package com.example.gongu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    // 문제 발생 23~25줄
    String text = "Find Password";
    SpannableString ss = new SpannableString(text);
    ss.setSpan(new UnderlineSpan(), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

}

