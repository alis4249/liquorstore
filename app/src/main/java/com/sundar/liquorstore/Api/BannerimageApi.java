package com.sundar.liquorstore.Api;

import java.util.List;
import com.sundar.liquorstore.model.BannerItem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BannerimageApi {

    @POST("banner/create")
    Call<Void> insertBanner(@Body BannerItem bannerItem);

    @GET("banner/all")
    Call<List<BannerItem>> getAllBanners();
}
