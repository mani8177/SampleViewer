package com.example.mani8177.cardtest;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by mani8177 on 7/30/15.
 */
public class Tab2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2,container,false);
        TextView tv = (TextView)v.findViewById(R.id.textView);
        if(tv != null) {
            displayContent(TabSampleActivity.sampleName,tv);

        }
        else
            Log.d(getActivity().toString(), "tv null");
        return v;
    }

    private void displayContent(String title,TextView txtView) {

        switch(title) {
            case "Geometry Sample": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.geometry_sample)); break;
            case "Identify Task": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.identify_task)); break;
            case "Offline Analysis": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.offline_analysis)); break;
            case "Query Task": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.query_task)); break;
            case "ViewShed": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.viewshed)); break;
            case "Add CSV File to a Graphics Layer": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.add_csv_file_to_a_graphics_layer)); break;
            case "Portal Featured User Groups": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.portal_featured_user_groups)); break;
            case "Query Feature Service Table": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.query_feature_service_table)); break;
            case "GeoJSON Earthquake Map": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.geojson_earthquake_map)); break;
            case "OAuth2": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.oauth2)); break;
            case "WebMap Popup Editing": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.webmap_popup_editing)); break;
            case "WebMap Popup Viewing": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.webmap_popup_viewing)); break;
            case "Query Cloud Feature Service": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.query_cloud_feature_service)); break;
            case "Standard License": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.standard_license)); break;
            case "Classbreaks Renderer": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.classbreaks_renderer)); break;
            case "Convert to MGRS Grid": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.convert_to_mgrs_grid)); break;
            case "Dynamic Layer Renderer": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.dynamic_layer_renderer)); break;
            case "Mil2525c Sample": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.mil2525c_sample)); break;
            case "Nearby Sample": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.nearby_sample)); break;
            case "Popup UI Customization": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.popup_ui_customization)); break;
            case "Unique Value Renderer": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.unique_value_renderer)); break;
            case "Attribute Editor": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.attribute_editor));
            case "Geometry Editor": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.geometry_editor)); break;
            case "Offline Editor": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.offline_editor)); break;
            case "Create Local Runtime Geodatabase": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.create_local_runtime_geodatabase)); break;
            case "Export Tile Cache": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.export_tile_cache)); break;
            case "Local MBTiles": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.local_mbtiles)); break;
            case "Standard Licensing Offline": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.standard_licensing_offline)); break;
            case "Basemaps": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.basemaps)); break;
            case "Basic License": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.basic_license)); break;
            case "Fragment Management": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.fragment_management)); break;
            case "Hello World Maps": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.hello_world_maps)); break;
            case "Map Rotation": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.map_rotation)); break;
            case "Simple Map": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.simple_map)); break;
            case "Switch Maps": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.switch_maps)); break;
            case "Closest Facilities": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.closest_facilities)); break;
            case "Routing": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.routing)); break;
            case "Offline Routing": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.offline_routing)); break;
            case "Service Area": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.service_area)); break;
            case "Place Search": txtView.setText(readFileFromResources(Tab2.this.getActivity(), R.raw.place_search)); break;
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
