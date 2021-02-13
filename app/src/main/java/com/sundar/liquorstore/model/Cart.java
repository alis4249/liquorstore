package com.sundar.liquorstore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cart {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("itemID")
    @Expose
    private Item item;
    @SerializedName("userId")
    @Expose
    private String userId;

    public Cart(String id, Item item, String userId) {
        this.id = id;
        this.item = item;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
