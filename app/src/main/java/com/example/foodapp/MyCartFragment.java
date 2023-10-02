package com.example.foodapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodapp.adapters.MyCartAdapter;
import com.example.foodapp.models.MyCartModel;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment {

    RecyclerView recyclerView;
    List<MyCartModel> list;
    MyCartAdapter myCartAdapter;

    public MyCartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_cart, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        list = new ArrayList<>();

        list.add(new MyCartModel(R.drawable.s1,"$40","5.0"));
        list.add(new MyCartModel(R.drawable.s2,"$20","4.3"));
        list.add(new MyCartModel(R.drawable.fav2,"$30","4.0"));

        myCartAdapter = new MyCartAdapter(getContext(),list);
        recyclerView.setAdapter(myCartAdapter);
        return view;
    }
}