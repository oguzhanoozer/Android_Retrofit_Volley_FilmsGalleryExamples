
package com.oguzhanozer.filmsapplication.ClassesForDB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Films implements Serializable {

    @SerializedName("film_id")
    @Expose
    private String filmId;
    @SerializedName("film_ad")
    @Expose
    private String film_name;
    @SerializedName("film_yil")
    @Expose
    private String film_year;
    @SerializedName("film_resim")
    @Expose
    private String film_image;
    @SerializedName("kategori")
    @Expose
    private Categories category;
    @SerializedName("yonetmen")
    @Expose
    private Directories yonetmen;

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public String getFilm_year() {
        return film_year;
    }

    public void setFilm_year(String film_year) {
        this.film_year = film_year;
    }

    public String getFilm_image() {
        return film_image;
    }

    public void setFilm_image(String film_image) {
        this.film_image = film_image;
    }

    public Categories getKategori() {
        return category;
    }

    public void setKategori(Categories kategori) {
        this.category = kategori;
    }

    public Directories getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(Directories yonetmen) {
        this.yonetmen = yonetmen;
    }

}
