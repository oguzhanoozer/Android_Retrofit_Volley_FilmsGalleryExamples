package com.oguzhanozer.filmsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.oguzhanozer.filmsapplication.Adapters.FilmsAdapter;
import com.oguzhanozer.filmsapplication.ClassesForDB.Categories;
import com.oguzhanozer.filmsapplication.ClassesForDB.Directories;
import com.oguzhanozer.filmsapplication.ClassesForDB.Films;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FilmsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView filmsRecyclerView;

    private ArrayList<Films> filmsArrayList;
    private FilmsAdapter filmsAdapter;

    private Categories categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

        toolbar = findViewById(R.id.myToolbar);
        filmsRecyclerView = findViewById(R.id.filmsRecylerView);


        categories = (Categories) getIntent().getSerializableExtra("categoryName");

        toolbar.setTitle(categories.getCategori_name());
        setSupportActionBar(toolbar);

        filmsRecyclerView.setHasFixedSize(true);
        filmsRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));


        getFilms(categories.getCategori_id());

    }

    public void getFilms(final int catg_id){

        String url = "http://kasimadalan.pe.hu/filmler/filmler_by_kategori_id.php";

        StringRequest postStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                filmsArrayList = new ArrayList<>();

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray films = jsonObject.getJSONArray("filmler");

                    for(int i=0;i<films.length();i++){

                        JSONObject film = films.getJSONObject(i);

                        int film_id = film.getInt("film_id");
                        String film_name = film.getString("film_ad");
                        int film_year = film.getInt("film_yil");
                        String film_image = film.getString("film_resim");

                        JSONObject f = film.getJSONObject("kategori");
                        int catg_id = f.getInt("kategori_id");
                        String catg_name = f.getString("kategori_ad");

                        JSONObject d = film.getJSONObject("yonetmen");
                        int direc_id = d.getInt("yonetmen_id");
                        String direc_name = d.getString("yonetmen_ad");

                    Categories categories = new Categories(catg_id,catg_name);
                    Directories directories = new Directories(direc_id,direc_name);


                    Films filmObj = new Films(film_id,film_name,film_year,film_image,categories,directories);

                    filmsArrayList.add(filmObj);

                    }

                    filmsAdapter = new FilmsAdapter(FilmsActivity.this,filmsArrayList);
                    filmsRecyclerView.setAdapter(filmsAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();

                params.put("kategori_id",String.valueOf(catg_id));
                return params;
            }
        };


        Volley.newRequestQueue(FilmsActivity.this).add(postStringRequest);


    }



}
