package com.sundar.liquorstore.Bll;

import com.sundar.liquorstore.Api.UsersApi;
import com.sundar.liquorstore.Url.url;
import com.sundar.liquorstore.model.Cart;

import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

public class cartBll {
    boolean isSuccess = false;

    public boolean checkcart(String userId, String itemID) {
        UsersApi usersAPI = url.getInstance().create(UsersApi.class);
        Call<Cart> addCart = usersAPI.addcart(url.token,itemID);
        try {
            Response<Cart> response = addCart.execute();
            if(response.code()==200)
            {
                isSuccess = true;
            }else {
                isSuccess = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
