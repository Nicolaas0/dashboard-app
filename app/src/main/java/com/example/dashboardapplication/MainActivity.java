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

    }

    public void login(View v){
        openlogin();
    }
    public void regist(View v){
        openregist();
    }
    public void openlogin(){
        startActivity(new Intent(getBaseContext(),loginActivity.class));
}

    public void openregist(){
        startActivity(new Intent(getBaseContext(),registerActivity.class));
    }
}