package com.viantec.web;

public class RecyclerViewItem {
    private int imageResourse;
    private String text1;
    private String text2;

    public RecyclerViewItem(int imageResourse, String text1, String text2) {
        this.imageResourse = imageResourse;
        this.text1 = text1;
        this.text2 = text2;
    }

    public RecyclerViewItem(int imageResourse, String text1) {
        this.imageResourse = imageResourse;
        this.text1 = text1;
    }

    public RecyclerViewItem(String text1) {
        this.text1 = text1;
    }

    public int getImageResourse() {
        return imageResourse;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
}
