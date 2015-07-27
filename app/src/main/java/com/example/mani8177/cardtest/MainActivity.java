package com.example.mani8177.cardtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends Activity {

    private static RecyclerView.Adapter adapter;
    private static RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<CategoryData> categories;
    static View.OnClickListener myOnClickListener;
    private static String TAG = "MainActivity";
    public static int depthLevel = -1;
    public static List<Integer> randomNumbers;
    public static String sampleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        myOnClickListener = new MyOnClickListener(this);

        getRandomNumber();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        categories = new ArrayList<CategoryData>();
        for (int i = 0; i < CategoryDetails.categoryArray.length; i++) {
            categories.add(new CategoryData(
                    CategoryDetails.categoryArray[i],
                    /*CategoryDetails.drawableArray[i],*/0,
                    CategoryDetails.id_[i],
                    ""
            ));
        }

        adapter = new MyAdapter(categories);
        recyclerView.setAdapter(adapter);
    }


    private class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            if (depthLevel == -1) {
                showItemList(v);
            } else {
                int selectedItemPosition = recyclerView.getChildPosition(v);
                RecyclerView.ViewHolder viewHolder
                        = recyclerView.findViewHolderForPosition(selectedItemPosition);
                TextView textViewName
                        = (TextView) viewHolder.itemView.findViewById(R.id.textViewCategory);

                String selectedName = String.valueOf( textViewName.getText());
                sampleName = selectedName;
                Intent intent = new Intent (context,SampleActivity.class);
                intent.putExtra("SampleName",sampleName);
                MainActivity.this.startActivity(intent);
            }
        }

        private void showItemList(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName
                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewCategory);

            String selectedName = String.valueOf( textViewName.getText());
            sampleName = selectedName;
            int selectedItemId = -1;
            for (int i = 0; i < CategoryDetails.categoryArray.length; i++) {
                if (selectedName.equals(CategoryDetails.categoryArray[i])) {
                    selectedItemId = CategoryDetails.id_[i];
                }
            }

            showSamplesList(selectedItemId, selectedName);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        return true;
    }


    private void showSamplesList(int selectedItemId, String selectedName) {

        depthLevel++;
        setTitle(selectedName);
        String[] tempArray = CategoryDetails.samplelist.get(selectedItemId);

        categories = new ArrayList<CategoryData>();
        for (int i = 0; i < tempArray.length; i++) {
            categories.add(new CategoryData(
                    tempArray[i],
                    CategoryDetails.drawableArray[i%tempArray.length],
                    CategoryDetails.id_[i%tempArray.length],
                    CategoryDetails.categoryDescription.get(i)
            ));
        }
        adapter = new MyAdapter(categories);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed(){
        if(depthLevel != -1) {
            setTitle(R.string.app_name);
            categories = new ArrayList<CategoryData>();
            for (int i = 0; i < CategoryDetails.categoryArray.length; i++) {
                categories.add(new CategoryData(
                        CategoryDetails.categoryArray[i],
                       0,
                        CategoryDetails.id_[i],
                        ""
                ));
            }
            depthLevel = -1;
            adapter = new MyAdapter(categories);
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            recyclerView.setAdapter(adapter);
        }
        else {
            super.onBackPressed();
        }

    }

    public void getRandomNumber () {

        Random random = new Random();
        int count = 8;
        randomNumbers = new ArrayList<Integer>(count);
        for (int i=0; i<count; i++) {
            int number;
            do {
                number = random.nextInt(CategoryDetails.myCardColors.size());
            } while (randomNumbers.contains(number));
            randomNumbers.add(number);
        }

        for(int i = 0; i < randomNumbers.size(); i++) {
            Log.d(TAG, randomNumbers.get(i) +"");
        }

    }
}
