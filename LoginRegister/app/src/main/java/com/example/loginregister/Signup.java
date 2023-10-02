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
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Signup extends AppCompatActivity {
    TextView gotologin;
    EditText ufirstname, ulastname, uemail, upassword, umobileno;
    Button signupbutton;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ufirstname = findViewById(R.id.ufirstname);
        ulastname = findViewById(R.id.ulastname);
        uemail = findViewById(R.id.uemail);
        upassword = findViewById(R.id.upassword);
        umobileno = findViewById(R.id.umobileno);

        progressBar = findViewById(R.id.progress_1);

        gotologin = findViewById(R.id.gotologin);
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gototologin = new Intent(getApplicationContext(), Login.class);
                startActivity(gototologin);
                finish();
            }
        });

        signupbutton = findViewById(R.id.signupbutton);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_firstname, user_lastname, user_phonenumber, user_mailaddress, user_password;
                user_firstname = String.valueOf(ufirstname.getText());
                user_lastname = String.valueOf(ulastname.getText());
                user_phonenumber = String.valueOf(umobileno.getText());
                user_mailaddress = String.valueOf(uemail.getText());
                user_password = String.valueOf(upassword.getText());

                if (!user_firstname.equals("") && !user_lastname.equals("") && !user_phonenumber.equals("") && !user_mailaddress.equals("") && !user_password.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[7];
                            field[0] = "user_firstname";
                            field[1] = "user_lastname";
                            field[3] = "user_mailaddress";
                            field[2] = "user_phonenumber";
                            field[4] = "user_password";
                            field[5] = "api_key";
                            field[6] = "api_admin_id";

                            //Creating array for data
                            String[] data = new String[7];
                            data[0] = user_firstname;
                            data[1] = user_lastname;
                            data[3] = user_mailaddress;
                            data[2] = user_phonenumber;
                            data[4] = user_password;
                            data[5] = "gdjehtyqc9sgwws4";
                            data[6] = "1";

                            PutData putData = new PutData("https://bakalabag.theinternetstore.in/administration/apis/signup_verification.api.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")){
                                        TastyToast.makeText(getApplicationContext(), result , TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
                                        Intent letsgetverify = new Intent(getApplicationContext(), otp_verify.class);
//                                        String Phone = user_phonenumber;
//                                        String Email = user_mailaddress;
                                        letsgetverify.putExtra("phone", user_phonenumber);
                                        startActivity(letsgetverify);
                                        finish();
                                    }
                                    else{
                                        TastyToast.makeText(getApplicationContext(), result , TastyToast.LENGTH_LONG, TastyToast.ERROR);
                                    }
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
                else {
                    TastyToast.makeText(getApplicationContext(), "All fields required" , TastyToast.LENGTH_LONG, TastyToast.CONFUSING);
                }
            }
        });
    }
}