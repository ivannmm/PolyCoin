package com.fierysoul.polycoin.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Util {

    public static int getDP(Context context, int dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    static String desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce dapibus convallis metus, fringilla elementum augue commodo nec. Praesent porta, ante at viverra finibus, nisl diam pulvinar lectus, sed accumsan nisi felis non nisl. In viverra pulvinar justo, vel placerat nibh. Aenean rutrum malesuada congue. Nam dictum, odio ac laoreet ullamcorper, massa augue consequat massa, at feugiat risus metus non tortor.";

    public static List<EventInfo> getEventInfo() {
        List<EventInfo> eventInfoList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.set(2022, 10, 14, 15, 32);
        eventInfoList.add(new EventInfo(1, "Отбор в Культорги", "Университетский",desc , "2134", cal, null));
        eventInfoList.add(new EventInfo(12, "312", "123", desc, "2134", cal, null));
        eventInfoList.add(new EventInfo(13, "313", "123", desc, "2134", cal, null));
        eventInfoList.add(new EventInfo(14, "314", "123", desc, "2134", cal, null));
        eventInfoList.add(new EventInfo(15, "315", "123", desc, "2134", cal, null));
        eventInfoList.add(new EventInfo(61, "316", "123", desc, "2134", cal, null));
        eventInfoList.add(new EventInfo(61, "317", "123", desc, "2134", cal, null));
        eventInfoList.add(new EventInfo(17, "318", "123", desc, "2134", cal, null));
        eventInfoList.add(new EventInfo(17, "319", "123", desc, "2134", cal, null));
        eventInfoList.add(new EventInfo(15, "3111", "123", desc, "2134", cal, null));
        return eventInfoList;
    }
}
