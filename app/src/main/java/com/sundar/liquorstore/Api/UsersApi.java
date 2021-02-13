package com.sundar.liquorstore.Api;

import com.sundar.liquorstore.ServerResponse.cartResponse;
import com.sundar.liquorstore.ServerResponse.ImageResponse;
import com.sundar.liquorstore.ServerResponse.SignUpResponse;
import com.sundar.liquorstore.model.Cart;
import com.sundar.liquorstore.model.User;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface UsersApi {
    @POST("/users/signup")
    Call<SignUpResponse> registerUser(@Body User user);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignUpResponse> CheckUser(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("cart/checkcart")
    Call<cartResponse> checkcart(@Field("itemID") String itemID, @Field("userid") String userid);

    @FormUrlEncoded
    @POST("cart/checkcart")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Call<cartResponse> checkcart(
            @Header("Authorization") String token,
            @Field("userId") String userid,
            @Field("itemID") String itemID);


    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Call<Cart> addcart(
            @Header("Authorization") String token,
            @Field("itemID") String itemID
    );
    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("users/me")
    Call<User> getUserDetails(@Header("Authorization") String token);

    @PUT("users/me")
    @FormUrlEncoded
    Call<User> updateUserDetails(
            @Header("Authorization") String token,
            @Field("firstName") String name,
            @Field("lastName") String lastnme,
            @Field("usernme") String username,
            @Field("image") String imageurl
    );
}
