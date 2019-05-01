package com.oguzhanozer.filmsapplication.RetrofitPackage;

import com.oguzhanozer.filmsapplication.CategoryResponse;
import com.oguzhanozer.filmsapplication.ClassesForDB.Categories;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryDaoInterface {


    @GET("filmler/tum_kategoriler.php")
    Call<CategoryResponse> allCategories();


}
