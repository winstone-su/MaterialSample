package com.geo.example.materialsample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder> {
//    private static final String TAG = "FlowerAdapter";
    private Context context;
    private List<Flower> mFlowerList;

    public FlowerAdapter(List<Flower> flowerList) {
        mFlowerList = flowerList;
    }

    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context ==  null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.flower_item,parent,false);
        final  FlowerViewHolder  holder = new FlowerViewHolder(view);
        holder.cardView.setOnClickListener(view1 -> {
            int position = holder.getAbsoluteAdapterPosition();
            Flower flower = mFlowerList.get(position);
            Intent intent = new Intent(context,FlowerActivity.class);
            intent.putExtra(FlowerActivity.FLOWER_NAME,flower.getName());
            intent.putExtra(FlowerActivity.FLOWER_IMAGE_ID,flower.getImageId());
            context.startActivity(intent);
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerViewHolder holder, int position) {
        Flower flower = mFlowerList.get(position);
        holder.flowerName.setText(flower.getName());
        Glide.with(context).load(flower.getImageId()).into(holder.flowerImage);
    }

    @Override
    public int getItemCount() {
        return mFlowerList.size();
    }

    static class FlowerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.flower_image)
        ImageView flowerImage;
        @BindView(R.id.flower_name)
        TextView flowerName;
        @BindView(R.id.cardView)
        CardView cardView;

        public FlowerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
