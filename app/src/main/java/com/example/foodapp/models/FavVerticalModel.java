package com.example.foodapp.models;

public class FavVerticalModel {

    int img_url;
    String name;
    String description;
    String rating;
    String timing;

    public FavVerticalModel(int img_url, String name, String description, String rating, String timing) {
        this.img_url = img_url;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.timing = timing;
    }

    public int getImg_url() {
        return img_url;
    }

    public void setImg_url(int img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
