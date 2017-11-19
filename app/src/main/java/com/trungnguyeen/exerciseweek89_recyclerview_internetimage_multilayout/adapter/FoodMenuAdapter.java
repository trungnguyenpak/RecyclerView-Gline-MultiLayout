package com.trungnguyeen.exerciseweek89_recyclerview_internetimage_multilayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.trungnguyeen.exerciseweek89_recyclerview_internetimage_multilayout.R;
import com.trungnguyeen.exerciseweek89_recyclerview_internetimage_multilayout.model.Food;

import java.util.ArrayList;

/**
 * Created by trungnguyeen on 11/19/17.
 */

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.FoodItemViewHolder> {


    private ArrayList<Food> mFoodList;
    private OnFoodClicked mListener;
    private final static  int VIEW_TYPE_ITEM_CHAN = 0;
    private final static int VIEW_TYPE_ITEM_LE = 1;

    @Override
    public FoodMenuAdapter.FoodItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemview = null;

        //Load layout with type
        if (viewType == VIEW_TYPE_ITEM_CHAN){
            itemview = layoutInflater.inflate(R.layout.custom_food_item_1, parent, false);
            return new FoodItemViewHolder(itemview);
        }
        else if(viewType == VIEW_TYPE_ITEM_LE){
            itemview = layoutInflater.inflate(R.layout.custom_food_item_2, parent, false);
            return new FoodItemViewHolder(itemview);
        }
        return null;
    }

    //Setup viewtype with position
    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0)
            return VIEW_TYPE_ITEM_CHAN;
        return VIEW_TYPE_ITEM_LE;
    }

    public void setmFoodList(ArrayList<Food> mFoodList) {
        this.mFoodList = mFoodList;
    }

    public void setmListener(OnFoodClicked mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onBindViewHolder(FoodMenuAdapter.FoodItemViewHolder holder, final int position) {

        final Food foodItem = mFoodList.get(position);

//        Glide.with(holder.imgFood)
//                .load(foodItem.getmImageUrl())
//                .into(holder.imgFood);
//        holder.tvFoodName.setText(foodItem.getmName());
//        holder.tvFoodPrice.setText(foodItem.getmPrice());


        if (holder.getItemViewType() == VIEW_TYPE_ITEM_CHAN){
            holder.bindView(foodItem);
            holder.btnOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.OnFoodClicked(position, foodItem);
                }
            });
        }
        else if(holder.getItemViewType() == VIEW_TYPE_ITEM_LE){
            holder.bindView(foodItem);
            holder.btnOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.OnFoodClicked(position, foodItem);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.mFoodList.size();
    }


    public static class FoodItemViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgFood;
        public TextView tvFoodName;
        public TextView tvFoodPrice;
        public Button btnOrder;



        public FoodItemViewHolder(View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgFood);
            tvFoodName = itemView.findViewById(R.id.tv_foodname);
            tvFoodPrice = itemView.findViewById(R.id.tv_foodprice);
            btnOrder = itemView.findViewById(R.id.btn_order);
        }

        public void bindView(Food foodItem) {
            Glide.with(imgFood)
                    .load(foodItem.getmImageUrl())
                    .into(imgFood);
            tvFoodName.setText(foodItem.getmName());
            tvFoodPrice.setText(foodItem.getmPrice());
        }
    }

    public interface OnFoodClicked{
        void OnFoodClicked(int position, Food food);
    }
}
