package com.example.prototype_db;

import android.widget.ImageView;

public class News {

    private String topic;
    private String text;
    private String imageUrl;

    public News(String topic, String text, String imageUrl) {
        this.topic = topic;
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
