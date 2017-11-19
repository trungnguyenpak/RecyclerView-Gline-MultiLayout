package com.trungnguyeen.exerciseweek89_recyclerview_internetimage_multilayout.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.trungnguyeen.exerciseweek89_recyclerview_internetimage_multilayout.R;
import com.trungnguyeen.exerciseweek89_recyclerview_internetimage_multilayout.adapter.FoodMenuAdapter;
import com.trungnguyeen.exerciseweek89_recyclerview_internetimage_multilayout.model.Food;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMenu;
    private ArrayList<Food> mFoodList;
    private FoodMenuAdapter mFoodMenuAdapter;

    public static final String FOOD = "FOOD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFoodList();

        rvMenu = (RecyclerView) findViewById(R.id.rv_menu);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvMenu.setLayoutManager(layoutManager);

        mFoodMenuAdapter = new FoodMenuAdapter();
        mFoodMenuAdapter.setmFoodList(mFoodList);
        mFoodMenuAdapter.setmListener(new FoodMenuAdapter.OnFoodClicked() {
            @Override
            public void OnFoodClicked(int position, Food food) {

                Intent intent = new Intent(MainActivity.this, DetailFoodActivity.class);
                intent.putExtra(FOOD, food);
                startActivity(intent);
            }
        });

        rvMenu.setAdapter(mFoodMenuAdapter);

    }

    public void createFoodList(){
        this.mFoodList = new ArrayList<>();
        this.mFoodList.add(new Food("Bún Bò","50.000", "https://i.ytimg.com/vi/F-hNUwfhtfc/maxresdefault.jpg"));
        this.mFoodList.add(new Food("Bánh Canh","60.000", "https://goo.gl/7kzTYd"));
        this.mFoodList.add(new Food("Phở Hà Nội","105.000", "https://goo.gl/tEWQZ4"));
        this.mFoodList.add(new Food("Thịt Heo Cuốn Bánh Tráng","105.000", "https://goo.gl/wtDxhn"));
        this.mFoodList.add(new Food("Bún Bò","50.000", "https://i.ytimg.com/vi/F-hNUwfhtfc/maxresdefault.jpg"));
        this.mFoodList.add(new Food("Bánh Canh","60.000", "https://goo.gl/7kzTYd"));
        this.mFoodList.add(new Food("Phở Hà Nội","105.000", "https://goo.gl/tEWQZ4"));
        this.mFoodList.add(new Food("Thịt Heo Cuốn Bánh Tráng","105.000", "https://goo.gl/wtDxhn"));
    }
}

