package com.example.loginregister;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.sdsmdg.tastytoast.TastyToast;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class otp_verify extends AppCompatActivity {

    EditText otp;
    Button verify;
    ProgressBar progressBar;
    String phoneno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verify);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent letsgetverify = getIntent();
        phoneno = letsgetverify.getStringExtra("phone");

        otp = findViewById(R.id.otp);
        progressBar = findViewById(R.id.progress_2);
        verify = findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_otp;
                user_otp = String.valueOf(otp.getText());


                if (!user_otp.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "user_phonenumber";
                            field[1] = "user_otp";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = phoneno;
                            data[1] = user_otp;

                            PutData putData = new PutData("https://bakalabag.theinternetstore.in/administration/apis/otp_verification.api.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Success")) {
                                        TastyToast.makeText(getApplicationContext(), result , TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
                                        Intent gotologinpage = new Intent(getApplicationContext(), Login.class);
                                        startActivity(gotologinpage);
                                        finish();
                                    } else {
                                        TastyToast.makeText(getApplicationContext(), result , TastyToast.LENGTH_LONG, TastyToast.ERROR);
                                    }
                                    //End ProgressBar (Set visibility to GONE)
                                }
                            }
                        }
                    });
                }
            }
        });
    }
}




