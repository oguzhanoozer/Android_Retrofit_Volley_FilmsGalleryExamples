package com.oguzhanozer.filmsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.oguzhanozer.filmsapplication.ClassesForDB.Categories;
import com.oguzhanozer.filmsapplication.Adapters.CategoryAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView categoryRecyclerView;

    private ArrayList<Categories> categoriesList;
    private CategoryAdapter categoryAdapter;

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

        allCategories();



    }

    public void allCategories(){

        String url = "http://kasimadalan.pe.hu/filmler/tum_kategoriler.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                categoriesList = new ArrayList<>();

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray categories = jsonObject.getJSONArray("kategoriler");

                    for(int i=0;i<categories.length();i++){

                        JSONObject catg = categories.getJSONObject(i);

                        int cat_id = catg.getInt("kategori_id");
                        String cat_name = catg.getString("kategori_ad");

                        Categories category = new Categories(cat_id,cat_name);

                        categoriesList.add(category);


                    }


                    categoryAdapter = new CategoryAdapter(MainActivity.this,categoriesList);

                    categoryRecyclerView.setAdapter(categoryAdapter);



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(MainActivity.this).add(stringRequest);

    }




}
