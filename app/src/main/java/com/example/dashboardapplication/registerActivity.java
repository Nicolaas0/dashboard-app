package com.example.dashboardapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import android.os.Bundle;

public class registerActivity extends AppCompatActivity {
    private EditText mViewUser, mViewPassword, mViewRepassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        mViewUser =findViewById(R.id.et_userregist);
        mViewPassword =findViewById(R.id.et_passregist);
        mViewRepassword =findViewById(R.id.et_repassregist);
    }
    /** Melakukan pegecekan inputan User dan Password dan Memberikan akses ke
     MainActivity */
    private void razia(){
        /* Mereset semua Error dan fokus menjadi default */
        mViewUser.setError(null);
        mViewPassword.setError(null);
        mViewRepassword.setError(null);
        View fokus = null;
        boolean cancel = false;
        /* Mengambil nilai dari UI komponen dengan variable baru bertipe String*/
        String repassword = mViewRepassword.getText().toString();
        String user = mViewUser.getText().toString();
        String password = mViewPassword.getText().toString();
        /* Pengecekan requirement username */
        if (TextUtils.isEmpty(user)){
            mViewUser.setError("This field is required");
            fokus = mViewUser;
            cancel = true;
        }else if(cekUser(user)){
            mViewUser.setError("This Username is already exist");
            fokus = mViewUser;
            cancel = true;
        }
        /* Pengecekan requirement password */
        if (TextUtils.isEmpty(password)){
            mViewPassword.setError("This field is required");
            fokus = mViewPassword;
            cancel = true;
        }else if (!cekPassword(password,repassword)){
            mViewRepassword.setError("This password is incorrect");
            fokus = mViewRepassword;
            cancel = true;
        }
        /* Jika cancel true, variable fokus mendapatkan fokus. Jika false, kembali
ke LoginActivity dan Set User dan Password untuk data yang terdaftar */
        if (cancel){
            fokus.requestFocus();
        }else{
            preferences.setRegisteredUser(getBaseContext(),user);
            preferences.setRegisteredPass(getBaseContext(),password);
            finish();
        }
    }
    /* True jika parameter password sama dengan parameter repassword */
    private boolean cekPassword(String password, String repassword){
        return password.equals(repassword);
    }
    /* True jika parameter user sama dengan data user yang terdaftar dari
    Preferences */
    private boolean cekUser(String user){
        return user.equals(preferences.getRegisteredUser(getBaseContext()));
    }
    public void create(View v){
        razia();
    }
    }
