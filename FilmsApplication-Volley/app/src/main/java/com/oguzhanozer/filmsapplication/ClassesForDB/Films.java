package com.oguzhanozer.filmsapplication.ClassesForDB;

import java.io.Serializable;

public class Films implements Serializable {

    private int film_id;
    private String film_name;
    private String film_image;
    private int film_year;
    private Categories categories;
    private Directories directories;

    private Films(){

    }

    public Films(int film_id, String film_name, int film_year,String film_image, Categories categories, Directories directories) {
        this.film_id = film_id;
        this.film_name = film_name;
        this.film_image = film_image;
        this.film_year = film_year;
        this.categories = categories;
        this.directories = directories;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public String getFilm_image() {
        return film_image;
    }

    public void setFilm_image(String film_image) {
        this.film_image = film_image;
    }

    public int getFilm_year() {
        return film_year;
    }

    public void setFilm_year(int film_year) {
        this.film_year = film_year;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Directories getDirectories() {
        return directories;
    }

    public void setDirectories(Directories directories) {
        this.directories = directories;
    }


}
