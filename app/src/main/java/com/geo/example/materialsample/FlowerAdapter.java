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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder> {
    private static final String TAG = "FlowerAdapter";
    private Context context;
    private List<Flower> mFlowerList;

    public FlowerAdapter(List<Flower> flowerList) {
        mFlowerList = mFlowerList;
    }

    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context ==  null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.flower_item,parent,false);
        final  FlowerViewHolder  holder = new FlowerViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Flower flower = mFlowerList.get(position);
                Intent intent = new Intent(context,FlowerActivity.class);
                intent.putExtra(FlowerActivity.FLOWER_NAME,flower.getName());
                intent.putExtra(FlowerActivity.FLOWERE_IMAGE_ID,flower.getImageId());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
