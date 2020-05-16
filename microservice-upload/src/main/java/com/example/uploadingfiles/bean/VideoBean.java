package com.example.uploadingfiles.bean;

public class VideoBean {

    private int id;

    private String name;

    private String path;

    private String picturePath;

    public VideoBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return "VideoBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }
}
