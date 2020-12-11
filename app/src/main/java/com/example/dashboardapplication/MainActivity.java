package com.example.dashboardapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        button = findViewById(R.id.tologin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });

        button2 = findViewById(R.id.toregist);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openregist();
            }
        });
    }

    public void openlogin(){
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);
    }

    public void openregist(){
        Intent intent = new Intent(this,registerActivity.class);
        startActivity(intent);
    }
}