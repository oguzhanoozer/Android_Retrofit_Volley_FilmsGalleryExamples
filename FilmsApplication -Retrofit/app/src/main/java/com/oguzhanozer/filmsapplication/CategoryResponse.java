
package com.oguzhanozer.filmsapplication;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.oguzhanozer.filmsapplication.ClassesForDB.Categories;

public class CategoryResponse {

    @SerializedName("kategoriler")
    @Expose
    private List<Categories> categoriesList = null;
    @SerializedName("success")
    @Expose
    private Integer success;

    public List<Categories> getCategoriesList() {
        return categoriesList;
    }

    public void setKategoriler(List<Categories> kategoriler) {
        this.categoriesList = kategoriler;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}
