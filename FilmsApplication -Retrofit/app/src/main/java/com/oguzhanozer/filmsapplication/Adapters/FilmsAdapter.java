package com.oguzhanozer.filmsapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oguzhanozer.filmsapplication.ClassesForDB.Films;
import com.oguzhanozer.filmsapplication.DetailActivity;
import com.oguzhanozer.filmsapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.CardDesignHolder>{

        private Context mContext;
        private List<Films> filmsList;


        public FilmsAdapter(Context mContext, List<Films> filmsList) {
            this.mContext = mContext;
            this.filmsList = filmsList;
        }

        @NonNull
        @Override
        public CardDesignHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.film_card_design,viewGroup,false);
            return new CardDesignHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull CardDesignHolder holder, int i) {

            final Films film = filmsList.get(i);

            holder.filmNameTextView.setText(film.getFilm_name());

            String url = "http://kasimadalan.pe.hu/filmler/resimler/"+film.getFilm_image();

            Picasso.get().load(url).into(holder.filmImageView);

            holder.filmCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext,DetailActivity.class);

                    intent.putExtra("nesne",film);

                    mContext.startActivity(intent);

                }
            });
        }

        @Override
        public int getItemCount() {
            return filmsList.size();
        }

        public class CardDesignHolder extends RecyclerView.ViewHolder{

            private CardView filmCardView;
            private TextView filmNameTextView;
            private ImageView filmImageView;


            public CardDesignHolder(@NonNull View itemView) {
                super(itemView);

                filmCardView = itemView.findViewById(R.id.filmsCardView);
                filmNameTextView = itemView.findViewById(R.id.filmNameTextView);
                filmImageView = itemView.findViewById(R.id.filmImageView);

            }

        }

    }
