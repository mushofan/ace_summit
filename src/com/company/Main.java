package com.company;

import java.net.URL;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        String jsonSource = "https://raw.githubusercontent.com/onaio/ona-tech/master/data/water_points.json";
        URL url = new URL(jsonSource);
        String stringUrl = "";

        FunctionClass functionClass = new FunctionClass();
        Deserialiser deserialiser = new Deserialiser();

        // Get json content of URL
        stringUrl = deserialiser.urlToString(url);
        // Parse json and create list of waterpoint
        List<WaterPoint> waterPointList =  deserialiser.deserialiseJson(stringUrl);

        // Create list of communities
        List<Community> communitiesList = functionClass.groupCommunities(waterPointList);

        // Create statistic
        Stats stats = functionClass.createStats(waterPointList, communitiesList);
        stats.showStats();
    }
}
