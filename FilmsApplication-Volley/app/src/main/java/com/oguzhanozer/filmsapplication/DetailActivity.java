package com.oguzhanozer.filmsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.oguzhanozer.filmsapplication.ClassesForDB.Films;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {


    private ImageView imageFilmDetail;
    private TextView textViewName,textViewYear,textViewDirector;

    private Films films;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        imageFilmDetail = findViewById(R.id.detailFilmImageView);
        textViewName = findViewById(R.id.detailFilmNameTextView);
        textViewYear = findViewById(R.id.detailFilmYearTextView);
        textViewDirector = findViewById(R.id.detailFilmDirectorTextView);

        films = (Films) getIntent().getSerializableExtra("nesne");

        textViewName.setText(films.getFilm_name());
        textViewYear.setText(String.valueOf(films.getFilm_year()));
        textViewDirector.setText(films.getDirectories().getDirector_name());

        String url = "http://kasimadalan.pe.hu/filmler/resimler/"+films.getFilm_image();

        Picasso.get().load(url).resize(700,1000).into(imageFilmDetail);

    }
}
