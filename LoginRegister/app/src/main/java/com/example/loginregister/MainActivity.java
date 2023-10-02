package com.example.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.allproducts.Example;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sdsmdg.tastytoast.TastyToast;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    EditText editText;
    SliderView sliderView;
    com.example.loginregister.SliderAdapter sliderAdapter;
    ImageView logoutfromMain,cart;
    int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    private static final String url = "https://bakalabag.theinternetstore.in/administration/apis/fetch_products.api.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoutfromMain = findViewById( R.id.logoutfromMain );
        logoutfromMain.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();
                Intent intent = new Intent(MainActivity.this, Login.class);
                TastyToast.makeText(getApplicationContext(), "Logout Successful" , TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
                startActivity(intent);
                finish();
            }
        } );

        cart = findViewById( R.id.cart );
        cart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoCart = new Intent(MainActivity.this, cart.class);
                startActivity(gotoCart);
                finish();
            }
        } );

        recyclerView = (RecyclerView) findViewById(R.id.products_recycler);
        gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        StringRequest request = new StringRequest( url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Example[] productsData = gson.fromJson( response, Example[].class );
                recyclerView.setAdapter( new productsAdapter( productsData,getApplicationContext() ) );
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        } );
        RequestQueue queue = Volley.newRequestQueue( this );
        queue.add( request );

        sliderView = findViewById(R.id.image_slider);
        sliderAdapter = new com.example.loginregister.SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        editText = findViewById(R.id.searchbar);

        BottomNavigationView bottomNavigationView = findViewById( R.id.bottom_bar );

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.cart:
                Intent gotoCart = new Intent(MainActivity.this, cart.class);
                startActivity(gotoCart);
                finish();
                break;
        }
        return true;
    }
}