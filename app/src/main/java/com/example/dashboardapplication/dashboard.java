package com.example.dashboardapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import android.os.Bundle;

public class dashboard extends AppCompatActivity {
    TextView nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        nama = (TextView)findViewById(R.id.tv_name);

        nama.setText(preferences.getLoggedInUser(getBaseContext()));
    }
}