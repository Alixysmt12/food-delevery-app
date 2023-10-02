package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.foodapp.adapters.MenuAdapter;
import com.example.foodapp.adapters.MenuDetAdapter;
import com.example.foodapp.models.MenuDetModel;
import com.example.foodapp.models.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class MenuDetailedActivity extends AppCompatActivity {

    ImageView imageView;
    RecyclerView recyclerView;
    MenuDetAdapter menuAdapter;
    List<MenuDetModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detailed);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        menuAdapter = new MenuDetAdapter(list);
        recyclerView.setAdapter(menuAdapter);

        if (type != null && type.equalsIgnoreCase("breakfast")){

            list.add(new MenuDetModel(R.drawable.fav1,"breakfast","description","$20","10 to 20","4.0"));
            list.add(new MenuDetModel(R.drawable.fav2,"breakfast2","description","$60","10 to 20","3.0"));
            list.add(new MenuDetModel(R.drawable.fav3,"breakfast3","description","$10","10 to 20","5.0"));
            menuAdapter.notifyDataSetChanged();
        }


        if (type != null && type.equalsIgnoreCase("sweets")){

            imageView.setImageResource(R.drawable.sweets);
            list.add(new MenuDetModel(R.drawable.s1,"sweets1","description","$20","10 to 20","4.0"));
            list.add(new MenuDetModel(R.drawable.s2,"sweets2","description","$40","10 to 20","5.0"));
            list.add(new MenuDetModel(R.drawable.s3,"sweets3","description","$230","10 to 20","3.0"));
            list.add(new MenuDetModel(R.drawable.s4,"sweets4","description","$10","10 to 20","4.0"));
            menuAdapter.notifyDataSetChanged();
        }





    }
}