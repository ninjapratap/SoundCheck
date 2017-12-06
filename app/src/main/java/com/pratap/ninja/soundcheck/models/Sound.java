package com.pratap.ninja.soundcheck.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by darsh on 6/12/17.
 */

public class Sound {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("genre")
    @Expose
    private String genre;

    public Sound(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
