
package com.oguzhanozer.filmsapplication.ClassesForDB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Directories implements Serializable {

    @SerializedName("yonetmen_id")
    @Expose
    private String director_id;
    @SerializedName("yonetmen_ad")
    @Expose
    private String director_name;

    public String getDirector_id() {
        return director_id;
    }

    public void setDirector_id(String director_id) {
        this.director_id = director_id;
    }

    public String getDirector_name() {
        return director_name;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

}
