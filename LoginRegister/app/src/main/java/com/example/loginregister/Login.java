package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;
import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class Login extends AppCompatActivity {

    TextView login, gotosignup;
    EditText imobileno, ipassword;
    Button loginbutton;
    ProgressBar progressBar;
    CheckBox rememberMe;
    String phoneno, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        login = findViewById(R.id.login);
        gotosignup = findViewById(R.id.gotosignup);

        imobileno = findViewById(R.id.imobileno);
        ipassword = findViewById(R.id.ipassword);

        progressBar = findViewById(R.id.progress);

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        if (checkbox.equals("true")){
            Intent welcome = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(welcome);
            finish();
        }
        else if (checkbox.equals("false")){
        }

        rememberMe = findViewById(R.id.rememberme);
        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    TastyToast.makeText(getApplicationContext(), "Checked", TastyToast.LENGTH_LONG, TastyToast.INFO);
                }
                else if (!compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    TastyToast.makeText(getApplicationContext(), "Unchecked", TastyToast.LENGTH_LONG, TastyToast.INFO);
                }
            }
        });

        gotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gototosignup = new Intent(getApplicationContext(), Signup.class);
                startActivity(gototosignup);
                finish();
            }
        });

        loginbutton = findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_phonenumber, user_password;
                user_phonenumber = String.valueOf(imobileno.getText());
                user_password = String.valueOf(ipassword.getText());

                if (!user_phonenumber.equals("") && !ipassword.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "user_phonenumber";
                            field[1] = "user_password";
                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = user_phonenumber;
                            data[1] = user_password;

                            PutData putData = new PutData("https://bakalabag.theinternetstore.in/administration/apis/login_verification.api.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Login Success")){
                                        TastyToast.makeText(getApplicationContext(), result , TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
                                        Intent loginsuccess = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(loginsuccess);
                                        finish();
                                    }
                                    else if(result.equals("Check Your Email First")){
                                        TastyToast.makeText(getApplicationContext(), result , TastyToast.LENGTH_LONG, TastyToast.INFO);
                                        Intent letsgetverify = new Intent(getApplicationContext(), otp_verify.class);
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