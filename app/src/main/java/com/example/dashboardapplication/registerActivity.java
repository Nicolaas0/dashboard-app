package com.example.dashboardapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;

import com.example.dashboardapplication.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.text.TextUtils.isEmpty;

public class registerActivity extends AppCompatActivity {
    private DatabaseReference database;

    private EditText etName;
    private EditText etPassword;
    private EditText etRepassword;
    private Button btnSubmit;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        firebaseAuth = firebaseAuth.getInstance();
        etName = findViewById(R.id.et_userregist);
        etPassword = findViewById(R.id.et_passregist);
        btnSubmit = findViewById(R.id.regisbutton);
    }

    public void submit(View v){
        String username = etName.getText().toString();
        String password = etPassword.getText().toString();
        if (!isEmpty(username) && !isEmpty(password)){
            createUser(username,password);
        }
        else {
            Snackbar.make(findViewById(R.id.regisbutton),"Registration Failed.",Snackbar.LENGTH_LONG).show();
        }
    }

    public void createUser(String username, String password){
        firebaseAuth.createUserWithEmailAndPassword(username,password).addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                openlogin();
            }
        });
    }

    public void openlogin(){
        Intent intent = new Intent (this,loginActivity.class);
        startActivity(intent);
    }

    public void goRegister(View v){
        Intent intent = new Intent(this,registerActivity.class);
        startActivity(intent);
    }
}
