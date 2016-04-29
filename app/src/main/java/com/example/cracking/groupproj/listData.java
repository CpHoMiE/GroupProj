package com.example.cracking.groupproj;

public class listData {
    private int image;
    private String name;
    private String tel;

    public listData(int image, String name, String tel){
        this.image = image;
        this.name = name;
        this.tel = tel;
    }
    public int getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
    public String getTel() {
        return tel;
    }

}