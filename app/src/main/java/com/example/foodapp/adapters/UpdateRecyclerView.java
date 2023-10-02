package com.example.foodapp.adapters;

import com.example.foodapp.models.DynamicRvModel;

import java.util.ArrayList;

public interface UpdateRecyclerView {
    public void callBack(int position, ArrayList<DynamicRvModel> item);
}
