package com.fierysoul.polycoin.util;

import android.annotation.SuppressLint;
import android.content.Context;

import com.fierysoul.polycoin.util.enums.InstEnum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Util {

    public static int getDP(Context context, int dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    static String desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce dapibus convallis metus, fringilla elementum augue commodo nec. Praesent porta, ante at viverra finibus, nisl diam pulvinar lectus, sed accumsan nisi felis non nisl. In viverra pulvinar justo, vel placerat nibh. Aenean rutrum malesuada congue. Nam dictum, odio ac laoreet ullamcorper, massa augue consequat massa, at feugiat risus metus non tortor.";

    public static List<EventInfo> getEventInfo() {
        List<EventInfo> eventInfoList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.set(2022, 11, 10, 18, 30);
        eventInfoList.add(new EventInfo(1, "REGREEN x YESLAB", "Университетский", "В программе:\n" +
                "— диалог о растительном питании с Лизой Чуршуковой, координатором Пищи для ума. Развеем мифы о растительном питании вместе \uD83C\uDF31\n" +
                "— рецепты и советы по приготовлению от YESLAB;\n" +
                "— согревающий чай с невероятными тофниками. Приходи, чтобы попробовать!" , "Студклуб, коворкинг Lepota", cal, null));
        eventInfoList.add(new EventInfo(12, "Чистый ноябрь", "Университетский", "Если хочешь присоединиться к нам, расскажи в комментариях в группе VK (@regreen_polytech), как хранение отходов организовано у тебя дома и куда обычно их сдаешь (можно даже приложить фото!)", "Студклуб, коворкинг Lepota", cal, null));


        eventInfoList.add(new EventInfo(13, "REGREEN x YESLAB", "Университетский", "В программе:\n" +
                "— диалог о растительном питании с Лизой Чуршуковой, координатором Пищи для ума. Развеем мифы о растительном питании вместе \uD83C\uDF31\n" +
                "— рецепты и советы по приготовлению от YESLAB;\n" +
                "— согревающий чай с невероятными тофниками. Приходи, чтобы попробовать!" , "Студклуб, коворкинг Lepota", cal, null));
        eventInfoList.add(new EventInfo(124, "Чистый ноябрь", "Университетский", "Если хочешь присоединиться к нам, расскажи в комментариях в группе VK (@regreen_polytech), как хранение отходов организовано у тебя дома и куда обычно их сдаешь (можно даже приложить фото!)", "Студклуб, коворкинг Lepota", cal, null));


        eventInfoList.add(new EventInfo(14, "REGREEN x YESLAB", "Университетский", "В программе:\n" +
                "— диалог о растительном питании с Лизой Чуршуковой, координатором Пищи для ума. Развеем мифы о растительном питании вместе \uD83C\uDF31\n" +
                "— рецепты и советы по приготовлению от YESLAB;\n" +
                "— согревающий чай с невероятными тофниками. Приходи, чтобы попробовать!" , "Студклуб, коворкинг Lepota", cal, null));
        eventInfoList.add(new EventInfo(125, "Чистый ноябрь", "Университетский", "Если хочешь присоединиться к нам, расскажи в комментариях в группе VK (@regreen_polytech), как хранение отходов организовано у тебя дома и куда обычно их сдаешь (можно даже приложить фото!)", "Студклуб, коворкинг Lepota", cal, null));

        return eventInfoList;
    }

    @SuppressLint("DefaultLocale")
    public static List<RatingUserInfo> getRatingUserInfo() {
        List<RatingUserInfo> rating = new ArrayList<>();
        String[] names = new String[] {"Иван", "Дмитрий", "Андрей", "Артем", "Максим", "Антон", "Ира", "Анна", "Саша"};
        String[] surname_male = new String[] {"Воробьев", "Снигерев", "Голубев", "Журавлев", "Воронов", "Синичкин", "Сорокин", "Синичкин", "Скворцов"};
        String[] surname_female = new String[] {"Воробьева", "Снигерева", "Голубева", "Журавлева", "Воронова", "Синичкина", "Сорокина", "Синичкина", "Скворцова"};
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            String name = names[random.nextInt(names.length)];
            String surname = (name.charAt(name.length() - 1) == 'а') ? surname_female[random.nextInt(surname_female.length)] : surname_male[random.nextInt(surname_male.length)];
            rating.add(new RatingUserInfo(String.format("%s %s", surname, name), InstEnum.FIZMEH, random.nextInt(500), random.nextInt(500), random.nextInt(500), random.nextInt(500), random.nextInt(500)));
        }

        return rating;
    }
}
