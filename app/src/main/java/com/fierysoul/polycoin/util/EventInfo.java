package com.fierysoul.polycoin.util;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventInfo {

    public static final Map<Calendar, List<EventInfo>> ALL_EVENTS = new HashMap<>();
    public static final Map<Calendar, List<EventInfo>> FAVORITE_EVENTS = new HashMap<>();

    public final int id;

    public final String name, level, description, place;

    public final Calendar fullDate;

    public final Map<String, Integer> roles_points;

    boolean isFavorite;

    public EventInfo(int id, String name, String level, String description, String place, Calendar fullDate, Map<String, Integer> roles_points) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.description = description;
        this.place = place;
        this.fullDate = fullDate;
        this.roles_points = roles_points;

        isFavorite = false;

        Calendar simpleDate = getSimpleDate(fullDate);

        if (ALL_EVENTS.containsKey(simpleDate)) {
            List<EventInfo> list = ALL_EVENTS.get(simpleDate);
            list.add(this);
        } else {
            List<EventInfo> list = new ArrayList<>();
            list.add(this);
            ALL_EVENTS.put(simpleDate, list);
        }
    }

    public Calendar getSimpleDate(Calendar fullDate) {
        Calendar simpleDate = Calendar.getInstance();
        simpleDate.set(Calendar.YEAR, fullDate.get(Calendar.YEAR));
        simpleDate.set(Calendar.MONTH, fullDate.get(Calendar.MONTH));
        simpleDate.set(Calendar.DAY_OF_MONTH, fullDate.get(Calendar.DAY_OF_MONTH));
        return simpleDate;
    }

    public boolean changeFavorite() {
        Calendar simpleDate = getSimpleDate(fullDate);
        List<EventInfo> favorites = FAVORITE_EVENTS.get(simpleDate);
        isFavorite = !isFavorite;

        if (!isFavorite) {
            if (favorites != null) {
                favorites.remove(this);
            }
        } else {
            if (favorites != null) {
                favorites.add(this);
            } else {
                List<EventInfo> list = new ArrayList<>();
                list.add(this);
                FAVORITE_EVENTS.put(simpleDate, list);
            }
        }
        return isFavorite;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof EventInfo))
            return false;
        EventInfo other = (EventInfo) obj;
        return other.id == this.id;
    }
}
