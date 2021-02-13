package com.sundar.liquorstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.sundar.liquorstore.Adapter.ItemRecyclerAdapter;
import com.sundar.liquorstore.Bll.DrinkBll;

public class HardDrinks_activity extends AppCompatActivity {
    private RecyclerView DrinkRecyclerView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_drinks_activity);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        mContext = this;
        PopulateRecyclerViewList();
    }

    public void PopulateRecyclerViewList(){
        DrinkRecyclerView = findViewById(R.id.Drinklist);
        DrinkBll drinkBll = new DrinkBll();
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(this,drinkBll.getAllItems());
        DrinkRecyclerView.setAdapter(itemRecyclerAdapter);
        DrinkRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
