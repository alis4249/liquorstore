package com.sundar.liquorstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.sundar.liquorstore.Adapter.ItemRecyclerAdapter;
import com.sundar.liquorstore.Bll.WineBll;

public class Wine_Activity extends AppCompatActivity {
    private RecyclerView item_recycleView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        PopulateRecyclerViewList();
    }
    public void PopulateRecyclerViewList(){
        item_recycleView1 = findViewById(R.id.wineList);
        WineBll wineBll = new WineBll();
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(this,wineBll.getAllItems());
        item_recycleView1.setAdapter(itemRecyclerAdapter);
        item_recycleView1.setLayoutManager(new LinearLayoutManager(this));
    }
}
