package com.fierysoul.polycoin.app.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fierysoul.polycoin.app.AppActivity;
import com.fierysoul.polycoin.R;

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
    }
}