package com.example.thuchanh1_3;

public class Thathinh {
    private String id;
    private String name;
    private String date;
    private int image;
    private float rate;

    public Thathinh() {
    }

    public Thathinh(String id, String name, String date, int image, float rate) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.image = image;
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
