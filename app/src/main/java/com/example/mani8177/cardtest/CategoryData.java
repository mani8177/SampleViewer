package com.example.mani8177.cardtest;

/**
 * Created by mani8177 on 7/16/15.
 */
public class CategoryData {

    String categoryName;
    int image;
    int id_;
    String summary;

    public CategoryData(String categoryName, int image, int id_, String text) {
        this.categoryName = categoryName;
        this.image = image;
        this.id_ = id_;
        this.summary = text;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }

    public String getSummary() {
        return summary;
    }
}
