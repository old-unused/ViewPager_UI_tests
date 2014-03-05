package com.retor.ViewPager_UI_tests;

import java.io.Serializable;

/**
 * Created by retor on 03.03.14.
 */
public class AuthorContainer implements Serializable {
    private String name;
    private int id;
    private String picture;

    //for groups
    public AuthorContainer(String _name, int _id, String _picture){
        setId(_id);
        setName(_name);
        setPicture(_picture);
    }

    //for people
    public AuthorContainer(String _name, String _lastName, int _id, String _picture){
        setId(_id);
        setName(_lastName+" "+_name);
        setPicture(_picture);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
