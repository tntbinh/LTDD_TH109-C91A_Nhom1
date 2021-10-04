package com.example.newsapp.object;

import android.content.Context;
import android.content.Intent;

import com.example.newsapp.DetailItemSearchActivity;

public class The_Slide_Items_Model_Class {
    private Context mContext;
    private int featured_image;
    private String the_caption_Title;
    private String link;

    public The_Slide_Items_Model_Class(int hero, String title, String link) {
        this.featured_image = hero;
        this.the_caption_Title = title;
        this.link = link;
    }

    public The_Slide_Items_Model_Class(Context mContext, int hero, String title, String link) {
        this.mContext = mContext;
        this.featured_image = hero;
        this.the_caption_Title = title;
    }

    public int getFeatured_image() {
        return featured_image;
    }

    public String getThe_caption_Title() {
        return the_caption_Title;
    }

    public void setFeatured_image(int featured_image) {
        this.featured_image = featured_image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setThe_caption_Title(String the_caption_Title) {
        this.the_caption_Title = the_caption_Title;
    }
}
