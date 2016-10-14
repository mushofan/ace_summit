package com.company;

import java.util.ArrayList;
import java.util.List;

public class Community implements Comparable<Community>{
    // Attributes
    private String name;
    private List<WaterPoint> waterPointList = new ArrayList<WaterPoint>();
    private int brokenWaterPoint = 0;
    private int functionalWaterPoint = 0;
    private int ranking = 0;

    // Getter & Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WaterPoint> getWaterPointList() {
        return waterPointList;
    }

    public void setWaterPointList(List<WaterPoint> waterPointList) {
        this.waterPointList = waterPointList;
    }

    public int getBrokenWaterPoint() {
        return brokenWaterPoint;
    }

    public void setBrokenWaterPoint(int brokenWaterPoint) {
        this.brokenWaterPoint = brokenWaterPoint;
    }

    public int getFunctionalWaterPoint() {
        return functionalWaterPoint;
    }

    public void setFunctionalWaterPoint(int functionalWaterPoint) {
        this.functionalWaterPoint = functionalWaterPoint;
    }

    public int getRanking(){
        return ranking;
    }

    public void setRanking(int ranking){
        this.ranking = ranking;
    }

    /* Other Functions */
    // Add water point
    public void addWaterPoint(WaterPoint waterPoint){
        waterPointList.add(waterPoint);
        if(waterPoint.getWaterFunctioning().equalsIgnoreCase("yes")){
            functionalWaterPoint++;
        }
        else{
            brokenWaterPoint++;
        }
    }
    // Count percentage of broken water point
    public float brokenWaterPercentage(){
        float percentage = ((float) brokenWaterPoint * 100/ waterPointList.size());
        return percentage;
    }

    // For sorting by percentage of broken water point
    @Override
    public int compareTo(Community community){
        return Float.valueOf(community.brokenWaterPercentage()).compareTo(Float.valueOf(this.brokenWaterPercentage()));
    }
}
