package com.sundar.liquorstore.Api;

import com.sundar.liquorstore.model.Cart;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface cartApi {

    @GET("mycart")
    Call<List<Cart>>getCart();

    @GET("mycart")
    Call<Cart> getImage(@Header("Authorization") String token);

    @POST("mycart")
    Call<Void> addtoitem(@Body Cart cart);
}
