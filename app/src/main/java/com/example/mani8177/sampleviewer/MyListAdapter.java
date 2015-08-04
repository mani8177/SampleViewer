package com.example.mani8177.sampleviewer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mani8177 on 7/27/15.
 */
public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private ArrayList<CategoryData> categoryDataSet;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView imgView;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.sampleName);
            txtFooter = (TextView) v.findViewById(R.id.sampleDesc);
            imgView = (ImageView) v.findViewById(R.id.icon);
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyListAdapter(ArrayList<CategoryData> categories) {
        this.categoryDataSet = categories;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        v.setOnClickListener(MainActivity.myOnClickListener);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        String temp_text = categoryDataSet.get(position).getCategoryName();
        holder.txtHeader.setText(temp_text);
        holder.txtFooter.setText("Footer: " + position);
        holder.imgView.setImageDrawable(MainActivity.roundImage);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return categoryDataSet.size();
    }
}
