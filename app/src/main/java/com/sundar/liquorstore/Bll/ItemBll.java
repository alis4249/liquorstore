package com.sundar.liquorstore.Bll;

import com.sundar.liquorstore.Api.ItemApi;
import com.sundar.liquorstore.Api.RetrofitCaller;
import com.sundar.liquorstore.model.Item;
import com.sundar.liquorstore.strictmode.strictmodeclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemBll {
     List<Item> itemList=  new ArrayList<>();
     Boolean status=false;
    ItemApi itemApi  = RetrofitCaller.getInstance().create(ItemApi.class);

    public  List<Item> getAllItems() {
     Call<List<Item>> itemsCall = itemApi.getAllItemsLIst();
        strictmodeclass.StrictMode();
        try {
            itemList=  itemsCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public  Boolean insertItem(Item item){
    Call<Void> voidCall = itemApi.insertItem(item);
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
