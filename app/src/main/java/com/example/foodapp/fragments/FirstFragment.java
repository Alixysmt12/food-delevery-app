package com.example.foodapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.example.foodapp.adapters.FavHorAdapter;
import com.example.foodapp.adapters.FavVerticalAdapter;
import com.example.foodapp.models.FavHorModel;
import com.example.foodapp.models.FavVerticalModel;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    RecyclerView recyclerViewHor,recyclerViewVer;
    List<FavHorModel> favHorModels;
    FavHorAdapter favHorAdapter;

    List<FavVerticalModel> favVerticalModels;
    FavVerticalAdapter favVerticalAdapter;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_first, container, false);

        recyclerViewHor = root.findViewById(R.id.fav_hor_rec);
        recyclerViewVer = root.findViewById(R.id.fav_lin_rec);

        favHorModels = new ArrayList<>();

        favHorModels.add(new FavHorModel(R.drawable.fav1,"description","coffee"));
        favHorModels.add(new FavHorModel(R.drawable.fav2,"description","coffee"));
        favHorModels.add(new FavHorModel(R.drawable.fav3,"description","coffee"));

        favHorAdapter = new FavHorAdapter(getActivity(),favHorModels);
        recyclerViewHor.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        recyclerViewHor.setAdapter(favHorAdapter);


        favVerticalModels = new ArrayList<>();
        favVerticalModels.add(new FavVerticalModel(R.drawable.ver1,"BreakFast","description","4.9","10:00 - 23:00"));
        favVerticalModels.add(new FavVerticalModel(R.drawable.ver2,"BreakFast","description","4.9","10:00 - 23:00"));
        favVerticalModels.add(new FavVerticalModel(R.drawable.ver3,"BreakFast","description","4.9","10:00 - 23:00"));

        favVerticalAdapter = new FavVerticalAdapter(getActivity(),favVerticalModels);
        recyclerViewVer.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewVer.setAdapter(favVerticalAdapter);
        return root;
    }
}