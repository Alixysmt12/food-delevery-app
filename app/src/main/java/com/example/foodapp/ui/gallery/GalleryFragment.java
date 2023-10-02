package com.example.foodapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.example.foodapp.adapters.MenuAdapter;
import com.example.foodapp.models.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    List<MenuModel> menuModelList;
    MenuAdapter menuAdapter;
    RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        recyclerView = root.findViewById(R.id.menu_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        menuModelList = new ArrayList<>();
        menuModelList.add(new MenuModel(R.drawable.breakfast,"Breakfast","20% Discount","description","breakfast"));
        menuModelList.add(new MenuModel(R.drawable.lunch,"Lunch","10% Discount","description","lunch"));
        menuModelList.add(new MenuModel(R.drawable.dinner,"Dinner","5% Discount","description","dinner"));
        menuModelList.add(new MenuModel(R.drawable.sweets,"Sweets","21% Discount","description","sweets"));
        menuModelList.add(new MenuModel(R.drawable.coffe,"coffee","11% Discount","description","coffee"));

        menuAdapter = new MenuAdapter(getActivity(),menuModelList);
        recyclerView.setAdapter(menuAdapter);
        menuAdapter.notifyDataSetChanged();
        return root;
    }
}