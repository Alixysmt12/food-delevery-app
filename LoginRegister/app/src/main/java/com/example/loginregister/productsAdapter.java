package com.example.loginregister;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.allproducts.Example;


public class productsAdapter extends RecyclerView.Adapter<productsAdapter.productsViewHolder> {
    Example[] productsData;
    Context context;

    public productsAdapter(Example[] productsData, Context context) {
        this.productsData = productsData;
        this.context = context;
    }

    @NonNull
    @Override
    public productsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View view = inflater.inflate( R.layout.items,parent,false );
        return new productsViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull productsViewHolder holder, int position) {
        Example example = productsData[position];
        holder.item_title.setText( example.getProductEnglishName() );
        holder.item_price.setText( example.getProductSellingPrice() );
        Glide.with( holder.item_img.getContext() ).load( "https://bakalabag.theinternetstore.in/resources/images/products/"
                + example.getProductEnglishName() + "-main.png" ).into( holder.item_img );

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showDetail = new Intent(holder.itemView.getContext(), com.example.loginregister.showDetail.class );
                showDetail.putExtra( "object", productsData[position] );
                holder.itemView.getContext().startActivity( showDetail );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return productsData.length;
    }

    public class productsViewHolder extends RecyclerView.ViewHolder {
        TextView item_title, item_price;
        ImageView item_img;

        public productsViewHolder(@NonNull View itemView) {
            super( itemView );
            item_title = (TextView) itemView.findViewById( R.id.item_title );
            item_price = (TextView) itemView.findViewById( R.id.item_price );
            item_img = (ImageView) itemView.findViewById( R.id.item_img );
        }
    }
}