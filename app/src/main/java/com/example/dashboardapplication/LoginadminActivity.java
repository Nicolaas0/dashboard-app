package com.example.dashboardapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.text.TextUtils.isEmpty;

public class LoginadminActivity extends AppCompatActivity {
    private EditText etName, etPassword;
    private Button btnSubmit;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginadmin);

        etName =findViewById(R.id.et_usernameloga);
        etPassword =findViewById(R.id.et_passloga);
        btnSubmit = findViewById(R.id.logbuttona);
        firebaseAuth = firebaseAuth.getInstance();
    }

    public void loginuser(View v){
        String email = etName.getText().toString();
        String password = etPassword.getText().toString();

        if (!isEmpty(email) && !isEmpty(password)){
            logincheck(email,password);
        }
        else{
            Snackbar.make(findViewById(R.id.logbutton),"Login Failed.",Snackbar.LENGTH_LONG).show();
        }
    }

    public void logincheck(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    openDashboard();
                }
                else{
                    Snackbar.make(findViewById(R.id.logbutton),"Login Failed.",Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    public void openDashboard(){
        Intent intent = new Intent(this,dashboard.class);
        startActivity(intent);}
}