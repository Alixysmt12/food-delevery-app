package com.example.foodapp.ui.home;

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
import com.example.foodapp.adapters.DynamiRvAdapter;
import com.example.foodapp.adapters.HorizontaHomeCategory;
import com.example.foodapp.adapters.UpdateRecyclerView;
import com.example.foodapp.models.DynamicRvModel;
import com.example.foodapp.models.HorizontalHomeModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements UpdateRecyclerView {
    private RecyclerView recyclerView,dynamicRec;
    private HorizontaHomeCategory adapter;
    private ArrayList<HorizontalHomeModel> list;

    private DynamiRvAdapter dynamiRvAdapter;
    private ArrayList<DynamicRvModel> dynamicRvModels;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.home_recyclerview);
        dynamicRec = root.findViewById(R.id.home_dynamic_recyclerview);

        list = new ArrayList<>();

        list.add(new HorizontalHomeModel(R.drawable.pizza, "Pizza"));
        list.add(new HorizontalHomeModel(R.drawable.hamburger, "HamBurger"));
        list.add(new HorizontalHomeModel(R.drawable.fried_potatoes, "Fries"));
        list.add(new HorizontalHomeModel(R.drawable.ice_cream, "Ice Cream"));
        list.add(new HorizontalHomeModel(R.drawable.sandwich, "Sandwich"));

        adapter = new HorizontaHomeCategory(list,getActivity(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        dynamicRvModels = new ArrayList<>();
//        dynamicRvModels.add(new DynamicRvModel(R.drawable.coffe,"coffee","10:00 - 23:00","4.9","Min - $35"));
//        dynamicRvModels.add(new DynamicRvModel(R.drawable.dinner,"coffee","10:00 - 23:00","4.9","Min - $35"));
//        dynamicRvModels.add(new DynamicRvModel(R.drawable.lunch,"coffee","10:00 - 23:00","4.9","Min - $35"));
//        dynamicRvModels.add(new DynamicRvModel(R.drawable.breakfast,"coffee","10:00 - 23:00","4.9","Min - $35"));
//        dynamicRvModels.add(new DynamicRvModel(R.drawable.sweets,"coffee","10:00 - 23:00","4.9","Min - $35"));

        dynamiRvAdapter = new DynamiRvAdapter(getContext(),dynamicRvModels);
        dynamicRec.setLayoutManager(new LinearLayoutManager(getContext()));
        dynamicRec.setAdapter(dynamiRvAdapter);
        return root;
    }

    @Override
    public void callBack(int position, ArrayList<DynamicRvModel> item) {

        dynamiRvAdapter = new DynamiRvAdapter(getContext(),item);
        dynamiRvAdapter.notifyDataSetChanged();
        dynamicRec.setAdapter(dynamiRvAdapter);

    }
}