package com.example.mani8177.sampleviewer;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mani8177 on 7/16/15.
 */
public class CategoryDetails {
    static String[] categoryArray = {"Analysis","Cloud & Portal", "Display Information", "Edit Data",
        "Local Data", "Maps", "Routing & Navigation", "Search"};

    static Integer[] drawableArray = {R.mipmap.analysis, R.mipmap.cloud, R.mipmap.display_info,
        R.mipmap.edit_data, R.mipmap.local_data, R.mipmap.maps, R.mipmap.routing, R.mipmap.search,R.mipmap.search};

    static Integer[] id_ = {0, 1, 2, 3, 4, 5, 6, 7,8};




    static String[] analysisArray = {"Geometry Sample", "Identify Task", "Offline Analysis", "Query Task", "ViewShed"};
    static String[] cloudPortalArray = {"Add CSV File to a Graphics Layer", "Portal Featured User Groups", "Query Feature Service Table",
        "GeoJSON Earthquake Map", "OAuth2", "WebMap Popup Editing", "WebMap Popup Viewing", "Query Cloud Feature Service", "Standard License"};
    static String[] displayInfoArray = {"Classbreaks Renderer", "Convert to MGRS Grid", "Dynamic Layer Renderer", "Mil2525c Sample", "Nearby Sample",
        "Popup UI Customization", "Unique Value Renderer"};
    static String[] editDataArray = {"Attribute Editor", "Geometry Editor", "Offline Editor"};
    static String[] localDataArray = {"Create Local Runtime Geodatabase", "Export Tile Cache", "Local MBTiles", "Standard Licensing Offline"};
    static String[] mapsArray = {"Basemaps", "Basic License", "Fragment Management", "Hello World Maps", "Map Rotation", "Simple Map", "Switch Maps"};
    static String[] routingArray = {"Closest Facilities", "Routing", "Offline Routing", "Service Area"};
    static String[] searchArray = {"Place Search"};

    static ArrayList<String[]> samplelist = new ArrayList<String[]>(Arrays.asList(analysisArray,cloudPortalArray,displayInfoArray,editDataArray,localDataArray,mapsArray,routingArray,searchArray));

    static ArrayList<Integer> myCardColors = new ArrayList<Integer>(Arrays.asList(
            Integer.valueOf(Color.parseColor("#F44336")), // Red 500
            Integer.valueOf(Color.parseColor("#E91E63")), // Pink 500
            Integer.valueOf(Color.parseColor("#9C27B0")), // Purple 500
            Integer.valueOf(Color.parseColor("#2196F3")), // Blue 500
            Integer.valueOf(Color.parseColor("#0277BD")), // Light Blue 800
            Integer.valueOf(Color.parseColor("#00838F")), // Cyan 800
            Integer.valueOf(Color.parseColor("#009688")), // Teal 500
            Integer.valueOf(Color.parseColor("#43A047")), // Green 600
            Integer.valueOf(Color.parseColor("#689F38")), // Light Green 700
            Integer.valueOf(Color.parseColor("#CDDC39")), // Lime 500
            Integer.valueOf(Color.parseColor("#FFC107")), // Amber 500
            Integer.valueOf(Color.parseColor("#EF6C00")), // Orange 800
            Integer.valueOf(Color.parseColor("#FF5722")), // Deep Orange 500
            Integer.valueOf(Color.parseColor("#607D8B")), // Blue Grey 500
            Integer.valueOf(Color.parseColor("#673AB7")), // Deep Purple 500
            Integer.valueOf(Color.parseColor("#3F51B5")), // Indigo 500
            Integer.valueOf(Color.parseColor("#757575")), // Grey 600
            Integer.valueOf(Color.parseColor("#795548")))); // Brown 500

    static ArrayList<String> categoryDescription = new ArrayList<>(Arrays.asList(
     "Click here to see samples on Analysis",
            "Click here to see samples on Cloud and Portal",
            "Click here to see samples on Display Information",
            "Click here to see samples on Edit Data",
            "Click here to see samples on Local Data",
            "Click here to see samples on Maps",
            "Click here to see samples on Routing and Navigation",
            "Click here to see samples on Search","hello how are you"
    ));

}

