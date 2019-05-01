package com.oguzhanozer.filmsapplication.RetrofitPackage;

import retrofit2.Retrofit;

public class ApiUtils {



    public static  final String BASE_URL = "http://kasimadalan.pe.hu/";

    public static FilmsDaoInterface getFilmsDaoInterface(){

       return RetrofitClient.getClient(BASE_URL).create(FilmsDaoInterface.class);

    }


    public static CategoryDaoInterface getCategoriesDaoInterface(){

        return RetrofitClient.getClient(BASE_URL).create(CategoryDaoInterface.class);
    }

}

