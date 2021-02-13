package com.sundar.liquorstore.Api;

import com.sundar.liquorstore.model.Cart;
import com.sundar.liquorstore.model.Item;
import com.sundar.liquorstore.ServerResponse.ImageResponse;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ItemApi {
    @GET("item/all")
    Call<List<Item>> getAllItemsLIst();

    @Multipart
    @POST("uploads")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @POST("item/create")
    Call<Void> insertItem(@Body Item item);

    @GET("cart/checkcart/")
    Call<List<Cart>> getcart(@Path("userId") String userid);

    @GET("cart/checkcart")
    Call<List<Cart>> getcartlist(@Header("Authorization") String token);

}
