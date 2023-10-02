package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.allproducts.Example;
import com.sdsmdg.tastytoast.TastyToast;

public class showDetail extends AppCompatActivity {
    private TextView detail_itemTitle,detail_itemPrice,noOfKg;
    private ImageView detail_itemImg, plusBtn, minusBtn;
    private Button addtocartBtn;
    private int kg = 1;
    Example object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_show_detail );

        initView();
        getBundle();

    }

    private void getBundle() {
        object = (Example) getIntent().getSerializableExtra( "object" );
        detail_itemTitle.setText( object.getProductEnglishName());
        detail_itemPrice.setText( object.getProductSellingPrice() );

        Glide.with( detail_itemImg.getContext() ).load( "https://bakalabag.theinternetstore.in/resources/images/products/"
                + object.getProductEnglishName() + "-main.png" ).into( detail_itemImg );

        noOfKg.setText(String.valueOf(kg));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kg = kg + 1;
                noOfKg.setText(String.valueOf(kg));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kg > 1) {
                    kg = kg - 1;
                }
                noOfKg.setText(String.valueOf(kg));
            }
        });

        addtocartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TastyToast.makeText( getApplicationContext(), String.valueOf( kg ) +" kg " + object.getProductEnglishName() + " added to your Cart", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS );
            }
        });

    }

    private void initView() {
        detail_itemTitle = findViewById( R.id.detail_itemTitle );
        detail_itemPrice = findViewById( R.id.detail_itemPrice );
        noOfKg = findViewById( R.id.noOfKg );

        detail_itemImg = findViewById( R.id.detail_itemImg );
        plusBtn = findViewById( R.id.plusBtn );
        minusBtn = findViewById( R.id.minusBtn );

        addtocartBtn = findViewById( R.id.addtocartBtn );

    }
}