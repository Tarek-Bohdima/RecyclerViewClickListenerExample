package com.example.recyclerviewclicklistenerexample;

/**
 * Created by Tarek on 10-Mar-19.
 */
public class TestItem {
    private String title;
    private String description;

    public TestItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
