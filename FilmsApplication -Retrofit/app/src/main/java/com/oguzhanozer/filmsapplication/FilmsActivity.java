package com.oguzhanozer.filmsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.oguzhanozer.filmsapplication.Adapters.FilmsAdapter;
import com.oguzhanozer.filmsapplication.ClassesForDB.Categories;
import com.oguzhanozer.filmsapplication.ClassesForDB.Films;
import com.oguzhanozer.filmsapplication.RetrofitPackage.ApiUtils;
import com.oguzhanozer.filmsapplication.RetrofitPackage.FilmsDaoInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView filmsRecyclerView;

    private ArrayList<Films> filmsArrayList;
    private FilmsAdapter filmsAdapter;

    private Categories categories;
    private FilmsDaoInterface filmsDaoInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

        toolbar = findViewById(R.id.myToolbar);
        filmsRecyclerView = findViewById(R.id.filmsRecylerView);

        categories = (Categories) getIntent().getSerializableExtra("categoryObj");

        filmsDaoInterface = ApiUtils.getFilmsDaoInterface();

        toolbar.setTitle(categories.getCategory_name());
        setSupportActionBar(toolbar);

        filmsRecyclerView.setHasFixedSize(true);
        filmsRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        filmsArrayList = new ArrayList<>();

        filmsDaoInterface.allFilmsByCategoryID(Integer.parseInt(categories.getCategory_id())).enqueue(new Callback<FilmResponse>() {
            @Override
            public void onResponse(Call<FilmResponse> call, Response<FilmResponse> response) {

                List<Films> films = response.body().getFilmler();


                filmsAdapter = new FilmsAdapter(FilmsActivity.this,films);
                filmsRecyclerView.setAdapter(filmsAdapter);

            }

            @Override
            public void onFailure(Call<FilmResponse> call, Throwable t) {

            }
        });


    }
}
