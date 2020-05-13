package com.livefox.video.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="VIDEO")
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String path;

    private String picturePath;

    public Video() {
    }

    public Video(int id, String name,String path,String picturePath) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.picturePath = picturePath;
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
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }
}
