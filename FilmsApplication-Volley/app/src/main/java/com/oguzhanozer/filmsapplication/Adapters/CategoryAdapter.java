package com.oguzhanozer.filmsapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oguzhanozer.filmsapplication.ClassesForDB.Categories;
import com.oguzhanozer.filmsapplication.FilmsActivity;
import com.oguzhanozer.filmsapplication.R;

import java.util.List;

public class CategoryAdapter extends  RecyclerView.Adapter<CategoryAdapter.CardDesignHolder> {

    private Context mContext;
    private List<Categories> categoriesList;


    public CategoryAdapter(Context mContext, List<Categories> categoriesList) {
        this.mContext = mContext;
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CardDesignHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_card_design,viewGroup,false);

        return new CardDesignHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CardDesignHolder holder, int i) {

        final Categories category = categoriesList.get(i);
        holder.textViewCategoryName.setText(category.getCategori_name());
        holder.category_CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,FilmsActivity.class);
                intent.putExtra("categoryName",category);
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class CardDesignHolder extends RecyclerView.ViewHolder{

        private CardView category_CardView;
        private TextView textViewCategoryName;

        public CardDesignHolder(@NonNull View itemView) {
            super(itemView);

            category_CardView = itemView.findViewById(R.id.category_Card);
            textViewCategoryName = itemView.findViewById(R.id.textViewCategory);

        }

    }

}
