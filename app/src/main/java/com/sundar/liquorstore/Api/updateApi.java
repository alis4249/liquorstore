package com.sundar.liquorstore.Api;

import com.sundar.liquorstore.model.Update;
import com.sundar.liquorstore.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface updateApi {
    @GET("update/all")
    Call<List<User>> getUserDetails();

    @POST("update/create")
    Call<Void> insertuser(@Body Update update);
}
