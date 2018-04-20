package com.example.rafael.doublelistview;

import java.util.ArrayList;

public class Item {
    private String text;
    private ArrayList<SubItem> subItems;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<SubItem> getSubItems() {
        return subItems;
    }

    public void setSubItems(ArrayList<SubItem> subItems) {
        this.subItems = subItems;
    }
}
