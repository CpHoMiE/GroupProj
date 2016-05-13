package com.example.cracking.groupproj;

public class listData {
    private int imageId;
    private String name;
    private String tel;

    public listData(int imageId, String name, String tel) {
        this.imageId = imageId;
        this.name= name;
        this.tel = tel;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }
    public void setName(String desc) {
        this.name = name;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String title) {
        this.tel= tel;
    }
    @Override
    public String toString() {
        return name + "\n" + tel;
    }
}