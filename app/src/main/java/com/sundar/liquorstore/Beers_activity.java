package com.sundar.liquorstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.sundar.liquorstore.Adapter.ItemRecyclerAdapter;
import com.sundar.liquorstore.Bll.BeerBll;

public class Beers_activity extends AppCompatActivity {
    private RecyclerView BeerRecyclerView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers_activity);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        mContext = this;
        PopulateRecyclerViewList();

    }
    public void PopulateRecyclerViewList(){
        BeerRecyclerView = findViewById(R.id.beerlist);
        BeerBll beerBll = new BeerBll();
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(this,beerBll.getAllItems());
        BeerRecyclerView.setAdapter(itemRecyclerAdapter);
        BeerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
