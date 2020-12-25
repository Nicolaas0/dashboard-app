package com.example.dashboardapplication;

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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.text.TextUtils.isEmpty;

public class registerActivity extends AppCompatActivity {
    private DatabaseReference database;

    private EditText etName;
    private EditText etPassword;
    private EditText etRepassword;
    private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        etName = findViewById(R.id.et_userregist);
        etPassword =findViewById(R.id.et_passregist);
        etRepassword =findViewById(R.id.et_repassregist);
        btnSubmit = findViewById(R.id.regisbutton);

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://dashboardapplication-48f2e-default-rtdb.firebaseio.com/");
    }

    private void create(View v){
        if (!isEmpty(etName.getText().toString()) && !isEmpty(etPassword.getText().toString())
        ) submitUser(new User(etName.getText().toString(), etPassword.getText().toString())
        );
        else
            Snackbar.make(findViewById(R.id.regisbutton),"Data Tidak Boleh Kosong!",Snackbar.LENGTH_LONG).show();

        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(etName.getWindowToken(),0);
    }



    private boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    private void submitUser(User user){
        database.child("user").push().setValue(user).addOnSuccessListener(this,new
                OnSuccessListener<Void>() {
            @Override
                    public void onSuccess(Void aVoid){
                etName.setText("");
                etPassword.setText("");
                etRepassword.setText("");
                Snackbar.make(findViewById(R.id.regisbutton),"Data berhasil di tambahkan",Snackbar.LENGTH_LONG).show();
            }
                });
    }

    public static Intent getActIntent(Activity activity) {
// kode untuk pengambilan Intent
        return new Intent(activity, registerActivity.class);
    }

    public void openlogin(){
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);}
}
