package com.sundar.liquorstore.Api;

import com.sundar.liquorstore.ServerResponse.ImageResponse;
import com.sundar.liquorstore.model.Item;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface BeerApi {
    @GET("Beer/all")
    Call<List<Item>> getAllItemsLIst();

    @Multipart
    @POST("uploads")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @POST("Beer/beer")
    Call<Void> insertItem(@Body Item item);
}
