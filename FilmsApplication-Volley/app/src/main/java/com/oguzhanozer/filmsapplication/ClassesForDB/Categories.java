package com.oguzhanozer.filmsapplication.ClassesForDB;

import java.io.Serializable;

public class Categories implements Serializable {

    private int categori_id;
    private String categori_name;

    public Categories(){

    }

    public Categories(int categori_id, String categori_name) {
        this.categori_id = categori_id;
        this.categori_name = categori_name;
    }

    public int getCategori_id() {
        return categori_id;
    }

    public void setCategori_id(int categori_id) {
        this.categori_id = categori_id;
    }

    public String getCategori_name() {
        return categori_name;
    }

    public void setCategori_name(String categori_name) {
        this.categori_name = categori_name;
    }
}
