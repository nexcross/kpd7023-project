package com.aqhmal.tempahanmakanan.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.aqhmal.tempahanmakanan.R;
import com.aqhmal.tempahanmakanan.model.Food;
import java.util.List;

public class RecyclerViewVerticalListAdapter extends RecyclerView.Adapter<RecyclerViewVerticalListAdapter.FoodViewHolder> {
    private List<Food> verticalFoodList;
    private Context context;

    public RecyclerViewVerticalListAdapter(List<Food> verticalFoodList, Context context) {
        this.verticalFoodList = verticalFoodList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View foodView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_list_food, parent, false);
        return new FoodViewHolder(foodView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.imageView.setImageResource(verticalFoodList.get(position).getFoodImage());
        holder.txtView.setText(verticalFoodList.get(position).getFoodName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodName = verticalFoodList.get(position).getFoodName();
                Toast.makeText(context, foodName + " has been added", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return  verticalFoodList.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtView;

        FoodViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.idFoodImage);
            txtView =  v.findViewById(R.id.idFoodName);
        }
    }
}