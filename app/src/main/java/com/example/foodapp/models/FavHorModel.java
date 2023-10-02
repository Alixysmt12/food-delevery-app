package com.example.foodapp.models;

public class FavHorModel {

    int image;
    String description;
    String Name;

    public FavHorModel(int image, String description, String name) {
        this.image = image;
        this.description = description;
        Name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
