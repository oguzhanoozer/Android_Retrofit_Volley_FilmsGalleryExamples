
package com.oguzhanozer.filmsapplication;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.oguzhanozer.filmsapplication.ClassesForDB.Films;

public class FilmResponse {

    @SerializedName("filmler")
    @Expose
    private List<Films> filmler = null;
    @SerializedName("success")
    @Expose
    private Integer success;

    public List<Films> getFilmler() {
        return filmler;
    }

    public void setFilmler(List<Films> filmler) {
        this.filmler = filmler;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}
