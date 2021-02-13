package com.sundar.liquorstore.model;

public class BannerItem {
    private String bannerName;
    private String images;
    private String  descriptions;

    public BannerItem(String bannerName, String images, String descriptions) {
        this.bannerName = bannerName;
        this.images = images;
        this.descriptions = descriptions;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
