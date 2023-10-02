package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class mobile_verify extends AppCompatActivity {

    EditText umobileno;
    Button getotp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_verify);
        umobileno = findViewById(R.id.umobileno);

        getotp = findViewById(R.id.verify);
        getotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), otp_verify.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
