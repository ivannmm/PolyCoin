package com.fierysoul.polycoin.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventInfo {

    public static final Map<Calendar, List<EventInfo>> ALL_EVENTS = new HashMap<>();

    String name, level, description, place;

    Calendar fullDate;

    Map<String, Integer> roles_points;

    public EventInfo(String name, String level, String description, String place, Calendar fullDate, Map<String, Integer> roles_points) {
        this.name = name;
        this.level = level;
        this.description = description;
        this.place = place;
        this.fullDate = fullDate;
        this.roles_points = roles_points;

        Calendar simpleDate = Calendar.getInstance();
        simpleDate.set(Calendar.YEAR, fullDate.get(Calendar.YEAR));
        simpleDate.set(Calendar.MONTH, fullDate.get(Calendar.MONTH));
        simpleDate.set(Calendar.DAY_OF_MONTH, fullDate.get(Calendar.DAY_OF_MONTH));
        if (ALL_EVENTS.containsKey(simpleDate)) {
            List<EventInfo> list = ALL_EVENTS.get(simpleDate);
            list.add(this);
        } else {
            List<EventInfo> list = new ArrayList<>();
            list.add(this);
            ALL_EVENTS.put(simpleDate, list);
        }
    }

}
