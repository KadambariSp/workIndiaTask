package com.example.workindiatask.Model;

public class itemModel {
    private final String name;
    private final String price;
    private final String extra;


    public itemModel(String name, String price, String extra) {
        this.name = name;
        this.price = price;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getExtra() {
        return extra;
    }
}

