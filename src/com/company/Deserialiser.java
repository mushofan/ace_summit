package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Deserialiser {
    // Get JSON content from URL
    public String urlToString(URL url){
        String stringUrl = "";
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while((read = reader.read(chars)) != -1){
                buffer.append(chars, 0, read);
            }
            stringUrl = buffer.toString();
        }
        catch (Exception e){
            System.out.println("Error!");
            System.out.println("Exception: "+e);
        }

        return stringUrl;
    }

    // Deserialise JSON
    public List<WaterPoint> deserialiseJson(String stringUrl){
        Gson gson = new Gson();

        // Use "Type" for defining class for list
        Type waterPointType = new TypeToken<ArrayList<WaterPoint>>(){}.getType();
        List<WaterPoint> waterPointList = gson.fromJson(stringUrl, waterPointType);

        return waterPointList;
    }
}
