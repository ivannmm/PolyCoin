package com.fierysoul.polycoin.app.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.fierysoul.polycoin.app.main.AppActivity;
import com.fierysoul.polycoin.R;
import com.fierysoul.polycoin.items.ShopItem;
import com.fierysoul.polycoin.util.Util;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, AppActivity.class);
            startActivity(intent);
        });

        cacheShopImages();
    }

    void cacheShopImages () {
        List<ShopItem> shopItems = Util.getShopItemList();
        for (ShopItem shopItem : shopItems) {
            ShopItem.CACHED_IMAGES.put(shopItem.id, Glide.with(this).load(shopItem.imgUrl));
        }
    }
}