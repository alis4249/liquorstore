package com.sundar.liquorstore.model;

public class Item {

    private String itemname;
    private int price;
    private String detail;
    private String image;

    public Item(String itemname, int price, String detail, String image) {
        this.itemname = itemname;
        this.price = price;
        this.detail = detail;
        this.image = image;
    }

    public String getItemName() {
        return itemname;
    }

    public void setItemName(String itemname) {
        this.itemname = itemname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
