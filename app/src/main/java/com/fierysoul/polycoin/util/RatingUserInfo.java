package com.fierysoul.polycoin.util;

public class RatingUserInfo implements Comparable<RatingUserInfo> {

    final String name, inst;
    final Integer points;

    public RatingUserInfo(String name, String inst, int points) {
        this.name = name;
        this.inst = inst;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public String getInst() {
        return inst;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public int compareTo(RatingUserInfo other) {
        return other.points.compareTo(points);
    }
}
