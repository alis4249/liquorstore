package com.sundar.liquorstore.Bll;

import com.sundar.liquorstore.Api.DrinksApi;
import com.sundar.liquorstore.Api.RetrofitCaller;
import com.sundar.liquorstore.model.Item;
import com.sundar.liquorstore.strictmode.strictmodeclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkBll {
    List<Item> itemList=  new ArrayList<>();
    Boolean status=false;
    DrinksApi drinksApi  = RetrofitCaller.getInstance().create(DrinksApi.class);

    public  List<Item> getAllItems() {
        Call<List<Item>> itemsCall = drinksApi.getAllItemsLIst();
        strictmodeclass.StrictMode();
        try {
            itemList=  itemsCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public  Boolean insertItem(Item item){
        Call<Void> voidCall = drinksApi.insertItem(item);
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    status=true;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                status=false;
            }
        });
        return  status;
    }
}
