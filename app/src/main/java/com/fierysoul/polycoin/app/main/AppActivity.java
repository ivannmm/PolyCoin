package com.fierysoul.polycoin.app.main;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.fierysoul.polycoin.R;
import com.fierysoul.polycoin.app.main.fragments.main.CalendarFragment;
import com.fierysoul.polycoin.app.main.fragments.main.ProfileFragment;
import com.fierysoul.polycoin.app.main.fragments.main.RatingFragment;
import com.fierysoul.polycoin.app.main.fragments.main.ShopFragment;
import com.fierysoul.polycoin.app.main.fragments.main.WalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.calendar:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, calendarFragment).commit();
                    return true;
                case R.id.rating:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, ratingFragment).commit();
                    return true;
                case R.id.profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
                    return true;
                case R.id.shop:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, shopFragment).commit();
                    return true;
                case R.id.wallet:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, walletFragment).commit();
                    return true;
            }
            return false;
        });
    }



    CalendarFragment calendarFragment = new CalendarFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    RatingFragment ratingFragment = new RatingFragment();
    ShopFragment shopFragment = new ShopFragment();
    WalletFragment walletFragment = new WalletFragment();

}