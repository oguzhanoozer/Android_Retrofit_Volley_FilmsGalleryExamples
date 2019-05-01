package com.oguzhanozer.filmsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.oguzhanozer.filmsapplication.Adapters.CategoryAdapter;
import com.oguzhanozer.filmsapplication.ClassesForDB.Categories;
import com.oguzhanozer.filmsapplication.RetrofitPackage.ApiUtils;
import com.oguzhanozer.filmsapplication.RetrofitPackage.CategoryDaoInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView categoryRecyclerView;

    private ArrayList<Categories> categoriesList;
    private CategoryAdapter categoryAdapter;

    private CategoryDaoInterface categoryDaoInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.myToolbar);
        categoryRecyclerView = findViewById(R.id.categoriRecyclerView);

        toolbar.setTitle("Categories");
        setSupportActionBar(toolbar);

        categoryRecyclerView.setHasFixedSize(true);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

       categoryDaoInterface = ApiUtils.getCategoriesDaoInterface();
       categoryDaoInterface.allCategories().enqueue(new Callback<CategoryResponse>() {

           @Override
           public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {

               List<Categories> categories = response.body().getCategoriesList();
               categoryAdapter = new CategoryAdapter(MainActivity.this,categories);
               categoryRecyclerView.setAdapter(categoryAdapter);

           }

           @Override
           public void onFailure(Call<CategoryResponse> call, Throwable t) {

           }
       });


    }
}
