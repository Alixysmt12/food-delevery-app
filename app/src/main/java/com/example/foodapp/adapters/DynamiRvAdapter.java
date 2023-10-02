package com.example.foodapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.example.foodapp.models.DynamicRvModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class DynamiRvAdapter extends RecyclerView.Adapter<DynamiRvAdapter.Viewholder> {

    private BottomSheetDialog bottomSheetDialog;
    Context context;
    ArrayList<DynamicRvModel> list;

    public DynamiRvAdapter(Context context, ArrayList<DynamicRvModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.display_home_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        final String prName = list.get(position).getName();
        final String prDes = list.get(position).getTiming();
        final String prRating = list.get(position).getRating();
        final int prImg = list.get(position).getImage();

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.timing.setText(list.get(position).getTiming());
        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice());
        holder.rating.setText(list.get(position).getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomSheetDialog = new BottomSheetDialog(context,R.style.BottomSheetTheme);

                View sheetView = LayoutInflater.from(context).inflate(R.layout.bootom_sheet_layout,null);
                sheetView.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"add to cart",Toast.LENGTH_LONG).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                ImageView imageView1 = sheetView.findViewById(R.id.pop_img);
                TextView name1 = sheetView.findViewById(R.id.nav_cat_name);
                TextView description1 = sheetView.findViewById(R.id.nav_cat_description);
                TextView price1 = sheetView.findViewById(R.id.textView10);


                name1.setText(prName);
                imageView1.setImageResource(prImg);
                description1.setText(prDes);
                price1.setText(prRating);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,rating,price,timing;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView2);
            name = itemView.findViewById(R.id.name);
            rating = itemView.findViewById(R.id.textView9);
            price = itemView.findViewById(R.id.price);
            timing = itemView.findViewById(R.id.textView8);
        }
    }
}
