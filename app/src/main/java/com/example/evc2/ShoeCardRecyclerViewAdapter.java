package com.example.evc2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evc2.network.ImageResquester;
import com.example.evc2.network.ShoeEntry;

import java.util.List;

public class ShoeCardRecyclerViewAdapter extends RecyclerView.Adapter<ShoeCardViewHolder> {
    private List<ShoeEntry> shoeList;
    private ImageResquester imageResquester;

    ShoeCardRecyclerViewAdapter(List<ShoeEntry> shoeList) {
        this.shoeList = shoeList;
        imageResquester = ImageResquester.getInstance();
    }

    @NonNull
    @Override
    public ShoeCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType ){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoe_card, parent, false);
        return new ShoeCardViewHolder(layoutView);
    }

    @Override
    public  void onBindViewHolder(@NonNull ShoeCardViewHolder holder, int position) {
        if(shoeList != null & position < shoeList.size()) {
            ShoeEntry shoe = shoeList.get(position);
            holder.shoeTitle.setText(shoe.title);
            holder.shoePrice.setText(shoe.price);
            imageResquester.setImageFromUrl(holder.shoeImage, shoe.url);
        }
    }
    @Override
    public  int getItemCount() {
        return shoeList.size();
    }
}
