package com.oguzhanozer.filmsapplication.RetrofitPackage;

import com.oguzhanozer.filmsapplication.FilmResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FilmsDaoInterface {

    @POST("filmler/filmler_by_kategori_id.php")
    @FormUrlEncoded
    Call<FilmResponse> allFilmsByCategoryID(@Field("kategori_id") int category_id);



}
