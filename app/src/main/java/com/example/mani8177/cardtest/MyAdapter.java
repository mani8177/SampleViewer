package com.example.mani8177.cardtest;

import android.graphics.Color;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;


/**
 * Created by mani8177 on 7/16/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<CategoryData> categoryDataSet;
    private static ArrayList<Integer> randomNum = new ArrayList<>();

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCategory;
        ImageView imageViewIcon;
        TextView summaryText;
        CardView cv;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewCategory = (TextView) itemView.findViewById(R.id.textViewCategory);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
            this.cv = (CardView) itemView.findViewById(R.id.card_view);
            this.summaryText = (TextView) itemView.findViewById(R.id.textViewSummary);
        }
    }

    public MyAdapter(ArrayList<CategoryData> categories) {
        this.categoryDataSet = categories;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);
        view.setPadding(8, 8, 8, 8);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewCategory = holder.textViewCategory;
        ImageView imageView = holder.imageViewIcon;

        textViewCategory.setText(categoryDataSet.get(listPosition).getCategoryName());
        imageView.setImageResource(categoryDataSet.get(listPosition).getImage());
        TextView summary = holder.summaryText;
        CardView cardView = holder.cv;
        if(MainActivity.depthLevel == -1) {
            int pos = MainActivity.randomNumbers.get(listPosition);
            cardView.setCardBackgroundColor(CategoryDetails.myCardColors.get(pos));
            summary.setTextColor(Color.WHITE);
        }
        else {
            textViewCategory.setTextColor(Color.BLACK);
        }


        summary.setText(categoryDataSet.get(listPosition).getSummary());

    }

    @Override
    public int getItemCount() {
        return categoryDataSet.size();
    }


}
