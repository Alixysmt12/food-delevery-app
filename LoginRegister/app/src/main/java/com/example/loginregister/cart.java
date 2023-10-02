package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class cart extends AppCompatActivity {
    ImageView cartTohome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cart );

        cartTohome = findViewById( R.id.cartTohome );
        cartTohome.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cartTohome = new Intent(cart.this, MainActivity.class);
                startActivity( cartTohome );
            }
        } );
    }
}