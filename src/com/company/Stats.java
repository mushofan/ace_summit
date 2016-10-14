package com.company;

import java.util.ArrayList;
import java.util.List;

public class Stats {
    private int functionalWater;
    private List<Community> communityList;

    // Constructor
    public Stats() {
        functionalWater = 0;
        communityList = new ArrayList<Community>();
    }

    public Stats(int functionalWater, List<Community> communityList) {
        this.functionalWater = functionalWater;
        this.communityList = communityList;
    }

    // Getter and Setter
    public int getFunctionalWater() {
        return functionalWater;
    }

    public void setFunctionalWater(int functionalWater) {
        this.functionalWater = functionalWater;
    }

    public List<Community> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(List<Community> communityList) {
        this.communityList = communityList;
    }

    /* Other Function(s) */
    // Show stats
    public void showStats(){
        System.out.println("Number of functional water: "+getFunctionalWater());
        System.out.println("");
        System.out.println("Number of water points per community: ");
        List<Community> communityList = getCommunityList();
        for (Community community:communityList) {
            System.out.println(community.getName()+": "+community.getWaterPointList().size());
        }
        System.out.println("");
        System.out.println("Ranking of community by the percentage of broken water points: ");
        for (Community community:communityList) {
            System.out.println(community.getName()+": "+community.getRanking());
        }
    }
}
