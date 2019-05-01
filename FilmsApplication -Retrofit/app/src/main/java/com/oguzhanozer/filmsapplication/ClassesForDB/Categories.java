
package com.oguzhanozer.filmsapplication.ClassesForDB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Categories implements Serializable {

    @SerializedName("kategori_id")
    @Expose
    private String category_id;
    @SerializedName("kategori_ad")
    @Expose
    private String category_name;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

}
