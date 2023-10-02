package com.example.foodapp.adapters;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.example.foodapp.models.DynamicRvModel;
import com.example.foodapp.models.HorizontalHomeModel;

import java.util.ArrayList;

public class HorizontaHomeCategory extends RecyclerView.Adapter<HorizontaHomeCategory.ViewHolder> {

    private ArrayList<HorizontalHomeModel> list;
    UpdateRecyclerView updateRecyclerView;
    Activity activity;
    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HorizontaHomeCategory(ArrayList<HorizontalHomeModel> list, Activity activity, UpdateRecyclerView updateRecyclerView) {
        this.list = list;
        this.activity = activity;
        this.updateRecyclerView = updateRecyclerView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HorizontalHomeModel staticRvModel = list.get(position);
        holder.textView.setText(staticRvModel.getText());
        holder.imageView.setImageResource(staticRvModel.getImage());

        if (check) {

            ArrayList<DynamicRvModel> dynamicRvModels = new ArrayList<>();

            dynamicRvModels.add(new DynamicRvModel(R.drawable.pizza1, "Pizza", "10:00 - 23:00", "4.9", "Min - $35"));
            dynamicRvModels.add(new DynamicRvModel(R.drawable.pizza2, "Pizza", "10:00 - 23:00", "5.0", "Min - $35"));
            dynamicRvModels.add(new DynamicRvModel(R.drawable.pizza3, "Pizza", "10:00 - 23:00", "3.9", "Min - $35"));
            dynamicRvModels.add(new DynamicRvModel(R.drawable.pizza4, "Pizza", "10:00 - 23:00", "3.9", "Min - $35"));

            updateRecyclerView.callBack(position, dynamicRvModels);
            check = false;
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                row_index = position;
                notifyDataSetChanged();

                if (position == 0) {

                    ArrayList<DynamicRvModel> dynamicRvModels = new ArrayList<>();

                    dynamicRvModels.add(new DynamicRvModel(R.drawable.pizza1, "Pizza", "10:00 - 23:00", "4.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.pizza2, "Pizza", "10:00 - 23:00", "5.0", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.pizza3, "Pizza", "10:00 - 23:00", "3.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.pizza4, "Pizza", "10:00 - 23:00", "3.9", "Min - $35"));

                    updateRecyclerView.callBack(position, dynamicRvModels);
                } else if (position == 1) {

                    ArrayList<DynamicRvModel> dynamicRvModels = new ArrayList<>();

                    dynamicRvModels.add(new DynamicRvModel(R.drawable.burger1, "Burger", "10:00 - 23:00", "4.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.burger2, "Burger", "10:00 - 23:00", "4.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.burger4, "Burger", "10:00 - 23:00", "4.9", "Min - $35"));

                    updateRecyclerView.callBack(position, dynamicRvModels);
                } else if (position == 2) {

                    ArrayList<DynamicRvModel> dynamicRvModels = new ArrayList<>();

                    dynamicRvModels.add(new DynamicRvModel(R.drawable.fries1, "Fries", "10:00 - 23:00", "4.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.fries2, "Fries", "10:00 - 23:00", "4.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.fries3, "Fries", "10:00 - 23:00", "4.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.fries4, "Fries", "10:00 - 23:00", "4.9", "Min - $35"));

                    updateRecyclerView.callBack(position, dynamicRvModels);
                } else if (position == 3) {

                    ArrayList<DynamicRvModel> dynamicRvModels = new ArrayList<>();

                    dynamicRvModels.add(new DynamicRvModel(R.drawable.icecream2, "ice Cream", "10:00 - 23:00", "5.0", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.icecream3, "ice Cream", "10:00 - 23:00", "4.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.icecream4, "ice Cream", "10:00 - 23:00", "3.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.icecream1, "ice Cream", "10:00 - 23:00", "5.0", "Min - $35"));

                    updateRecyclerView.callBack(position, dynamicRvModels);
                } else if (position == 4) {

                    ArrayList<DynamicRvModel> dynamicRvModels = new ArrayList<>();

                    dynamicRvModels.add(new DynamicRvModel(R.drawable.sandwich1, "Sandwich", "10:00 - 23:00", "4.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.sandwich2, "Sandwich", "10:00 - 23:00", "4.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.sandwich3, "Sandwich", "10:00 - 23:00", "4.9", "Min - $35"));
                    dynamicRvModels.add(new DynamicRvModel(R.drawable.sandwich4, "Sandwich", "10:00 - 23:00", "4.9", "Min - $35"));

                    updateRecyclerView.callBack(position, dynamicRvModels);
                }
            }
        });


        if (select) {
            if (position == 0) {

                holder.cardView.setBackgroundResource(R.drawable.dynamic_rv_bg);
                select = false;
            }
        } else {
            if (row_index == position) {
                holder.cardView.setBackgroundResource(R.drawable.dynamic_rv_bg);

            } else {
                holder.cardView.setBackgroundResource(R.drawable.static_rv_bg);

            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.static_txt);
            imageView = itemView.findViewById(R.id.static_img);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
