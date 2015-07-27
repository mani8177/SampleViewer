package com.example.mani8177.cardtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class SampleActivity extends ActionBarActivity implements ViewTreeObserver.OnScrollChangedListener {

    Toolbar toolbar;
    ImageButton FAB;
    private float mActionBarHeight;
    private ActionBar mActionBar;


    private static String TAG = "SampleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_info);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String message = intent.getStringExtra("SampleName");


        setTitle(message);

        final TypedArray styledAttributes = getTheme().obtainStyledAttributes(
                new int[]{android.R.attr.actionBarSize});
        mActionBarHeight = styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        mActionBar = getSupportActionBar();


        FAB = (ImageButton) findViewById(R.id.imageButton);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(SampleActivity.this, "Hello World", Toast.LENGTH_SHORT).show();


            }
        });
        ScrollView scrollView = (ScrollView)findViewById(R.id.scrollView);
        scrollView.setSmoothScrollingEnabled(true);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(this);



        displayContent(message);

    }

    @Override
    public void onScrollChanged() {

        float y = ((ScrollView)findViewById(R.id.scrollView)).getScrollY();
        if (y >= 20 && mActionBar.isShowing()) {
           // mActionBar.setShowHideAnimationEnabled(true);
            toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
            mActionBar.hide();
            FAB.setVisibility(View.GONE);

        } else if ( y <= 20 && !mActionBar.isShowing()) {
            toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
            mActionBar.show();
            FAB.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayContent(String title) {

        TextView txtView = (TextView)findViewById(R.id.sampleTextView);
        switch(title) {
            case "Geometry Sample": txtView.setText(readFileFromResources(this, R.raw.geometry_sample)); break;
            case "Identify Task": txtView.setText(readFileFromResources(this, R.raw.identify_task)); break;
            case "Offline Analysis": txtView.setText(readFileFromResources(this, R.raw.offline_analysis)); break;
            case "Query Task": txtView.setText(readFileFromResources(this, R.raw.query_task)); break;
            case "ViewShed": txtView.setText(readFileFromResources(this, R.raw.viewshed)); break;
            case "Add CSV File to a Graphics Layer": txtView.setText(readFileFromResources(this, R.raw.add_csv_file_to_a_graphics_layer)); break;
            case "Portal Featured User Groups": txtView.setText(readFileFromResources(this, R.raw.portal_featured_user_groups)); break;
            case "Query Feature Service Table": txtView.setText(readFileFromResources(this, R.raw.query_feature_service_table)); break;
            case "GeoJSON Earthquake Map": txtView.setText(readFileFromResources(this, R.raw.geojson_earthquake_map)); break;
            case "OAuth2": txtView.setText(readFileFromResources(this, R.raw.oauth2)); break;
            case "WebMap Popup Editing": txtView.setText(readFileFromResources(this, R.raw.webmap_popup_editing)); break;
            case "WebMap Popup Viewing": txtView.setText(readFileFromResources(this, R.raw.webmap_popup_viewing)); break;
            case "Query Cloud Feature Service": txtView.setText(readFileFromResources(this, R.raw.query_cloud_feature_service)); break;
            case "Standard License": txtView.setText(readFileFromResources(this, R.raw.standard_license)); break;
            case "Classbreaks Renderer": txtView.setText(readFileFromResources(this, R.raw.classbreaks_renderer)); break;
            case "Convert to MGRS Grid": txtView.setText(readFileFromResources(this, R.raw.convert_to_mgrs_grid)); break;
            case "Dynamic Layer Renderer": txtView.setText(readFileFromResources(this, R.raw.dynamic_layer_renderer)); break;
            case "Mil2525c Sample": txtView.setText(readFileFromResources(this, R.raw.mil2525c_sample)); break;
            case "Nearby Sample": txtView.setText(readFileFromResources(this, R.raw.nearby_sample)); break;
            case "Popup UI Customization": txtView.setText(readFileFromResources(this, R.raw.popup_ui_customization)); break;
            case "Unique Value Renderer": txtView.setText(readFileFromResources(this, R.raw.unique_value_renderer)); break;
            case "Attribute Editor": txtView.setText(readFileFromResources(this, R.raw.attribute_editor));
            case "Geometry Editor": txtView.setText(readFileFromResources(this, R.raw.geometry_editor)); break;
            case "Offline Editor": txtView.setText(readFileFromResources(this, R.raw.offline_editor)); break;
            case "Create Local Runtime Geodatabase": txtView.setText(readFileFromResources(this, R.raw.create_local_runtime_geodatabase)); break;
            case "Export Tile Cache": txtView.setText(readFileFromResources(this, R.raw.export_tile_cache)); break;
            case "Local MBTiles": txtView.setText(readFileFromResources(this, R.raw.local_mbtiles)); break;
            case "Standard Licensing Offline": txtView.setText(readFileFromResources(this, R.raw.standard_licensing_offline)); break;
            case "Basemaps": txtView.setText(readFileFromResources(this, R.raw.basemaps)); break;
            case "Basic License": txtView.setText(readFileFromResources(this, R.raw.basic_license)); break;
            case "Fragment Management": txtView.setText(readFileFromResources(this, R.raw.fragment_management)); break;
            case "Hello World Maps": txtView.setText(readFileFromResources(this, R.raw.hello_world_maps)); break;
            case "Map Rotation": txtView.setText(readFileFromResources(this, R.raw.map_rotation)); break;
            case "Simple Map": txtView.setText(readFileFromResources(this, R.raw.simple_map)); break;
            case "Switch Maps": txtView.setText(readFileFromResources(this, R.raw.switch_maps)); break;
            case "Closest Facilities": txtView.setText(readFileFromResources(this, R.raw.closest_facilities)); break;
            case "Routing": txtView.setText(readFileFromResources(this, R.raw.routing)); break;
            case "Offline Routing": txtView.setText(readFileFromResources(this, R.raw.offline_routing)); break;
            case "Service Area": txtView.setText(readFileFromResources(this, R.raw.service_area)); break;
            case "Place Search": txtView.setText(readFileFromResources(this, R.raw.place_search)); break;
        }


    }

    public static String readFileFromResources(Context ctx, int resId){
        InputStream inputStream = ctx.getResources().openRawResource(resId);

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;
        StringBuilder text = new StringBuilder();

        try {
            while (( line = buffreader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
        } catch (IOException e) {
            return null;
        }
        return text.toString();
    }
}
