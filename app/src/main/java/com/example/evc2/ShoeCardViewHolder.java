package com.example.evc2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class ShoeCardViewHolder extends  RecyclerView.ViewHolder {
    public NetworkImageView shoeImage;
    public TextView shoeTitle;
    public TextView shoePrice;

    public ShoeCardViewHolder(@NonNull View itemView) {
        super(itemView);
        shoeImage = itemView.findViewById(R.id.shoe_image);
        shoeTitle = itemView.findViewById(R.id.shoe_title);
        shoePrice = itemView.findViewById(R.id.shoe_price);
    }
}
