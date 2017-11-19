package com.trungnguyeen.exerciseweek89_recyclerview_internetimage_multilayout.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.trungnguyeen.exerciseweek89_recyclerview_internetimage_multilayout.R;
import com.trungnguyeen.exerciseweek89_recyclerview_internetimage_multilayout.model.Food;

/**
 * Created by trungnguyeen on 11/19/17.
 */

public class DetailFoodActivity extends AppCompatActivity {

    private ImageView imgFood;
    private TextView tvFoodName;
    private TextView tvFoodPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        imgFood = (ImageView) findViewById(R.id.imgFood);
        tvFoodName = (TextView) findViewById(R.id.tv_foodname);
        tvFoodPrice = (TextView) findViewById(R.id.tv_foodprice);

        Intent intent = getIntent();
        if (intent != null){
            Food foodItem = (Food) intent.getSerializableExtra(MainActivity.FOOD);

            Glide.with(imgFood).load(foodItem.getmImageUrl()).into(imgFood);
            tvFoodName.setText(foodItem.getmName());
            tvFoodPrice.setText(foodItem.getmPrice());
        }
    }
}
