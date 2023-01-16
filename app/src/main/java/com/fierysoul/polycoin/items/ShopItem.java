package com.fierysoul.polycoin.items;

import android.graphics.drawable.Drawable;

import com.bumptech.glide.RequestBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopItem {

    public static final List<ShopItem> ALL_ITEMS = new ArrayList<>();

    public static final Map<Integer, RequestBuilder<Drawable>> CACHED_IMAGES = new HashMap<>();

    public final int id, price;

    public final String name, desc, imgUrl;

    boolean isAuction;

    Calendar auctionDate;

    public ShopItem(int id, String name, int price, String desc, boolean isAuction, Calendar auctionDate, String imgUrl) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.imgUrl = imgUrl;
        this.price = price;
        this.isAuction = isAuction;
        this.auctionDate = auctionDate;
    }

    public ShopItem(int id, String name, int price, String desc, String imgUrl) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.imgUrl = imgUrl;
        this.price = price;
        this.isAuction = false;
        this.auctionDate = null;
    }

}
