package com.company;

import java.util.*;

public class FunctionClass {
    // Count total number of functional water point from all communities
    public int sumFunctionalWater(List<WaterPoint> waterPointList){
        int functionalWaterPoint = 0;
        for (WaterPoint waterPoint: waterPointList) {
            if(waterPoint.getWaterFunctioning().equalsIgnoreCase("yes")){
                functionalWaterPoint++;
            }
        }
        return functionalWaterPoint;
    }

    // Create and sort list of communities
    public List<Community> groupCommunities(List<WaterPoint> waterPointList){
        List<Community> communities = new ArrayList<Community>();
        Map<String, Community> communityMap = new HashMap<String, Community>();
        String communityName = "";

        for (WaterPoint waterPoint: waterPointList) {
            communityName = waterPoint.getCommunitiesVillages();

            if(communityMap.containsKey(communityName)){
                Community community = communityMap.get(communityName);
                community.addWaterPoint(waterPoint);
            }
            else{
                Community community = new Community();
                community.setName(communityName);
                community.addWaterPoint(waterPoint);
                communityMap.put(communityName, community);
            }
        }
        communities.addAll(communityMap.values());
        Collections.sort(communities);

        int i = 1;
        for (Community community:communities) {
            community.setRanking(i);
            i++;
        }

        return communities;
    }

    // Create stats
    public Stats createStats(List<WaterPoint> waterPointList, List<Community> communityList){
        int functionalWater = sumFunctionalWater(waterPointList);
        Stats stats = new Stats(functionalWater, communityList);

        return stats;
    }
}
