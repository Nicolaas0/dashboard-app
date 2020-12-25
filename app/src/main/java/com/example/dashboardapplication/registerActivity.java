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

    private void create(){
        if (!isEmpty(etName.getText().toString()) && !isEmpty(etPassword.getText().toString())
        ) submitUser(new User(etName.getText().toString(),
                etPassword.getText().toString())
        );
        else
            Snackbar.make(findViewById(R.id.regisbutton),"Data Tidak Boleh Kosong!",Snackbar.LENGTH_LONG).show();

        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(etName.getWindowToken(),0);
    }

    public void submit(View v){
        create();
        openlogin();
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

    /** Melakukan pegecekan inputan User dan Password dan Memberikan akses ke
     MainActivity */
//    private void razia(){
//        /* Mereset semua Error dan fokus menjadi default */
//        mViewUser.setError(null);
//        mViewPassword.setError(null);
//        mViewRepassword.setError(null);
//        View fokus = null;
//        boolean cancel = false;
//        /* Mengambil nilai dari UI komponen dengan variable baru bertipe String*/
//        String repassword = mViewRepassword.getText().toString();
//        String user = mViewUser.getText().toString();
//        String password = mViewPassword.getText().toString();
//        /* Pengecekan requirement username */
//        if (TextUtils.isEmpty(user)){
//            mViewUser.setError("This field is required");
//            fokus = mViewUser;
//            cancel = true;
//        }else if(cekUser(user)){
//            mViewUser.setError("This Username is already exist");
//            fokus = mViewUser;
//            cancel = true;
//        }
//        /* Pengecekan requirement password */
//        if (TextUtils.isEmpty(password)){
//            mViewPassword.setError("This field is required");
//            fokus = mViewPassword;
//            cancel = true;
//        }else if (!cekPassword(password,repassword)){
//            mViewRepassword.setError("This password is incorrect");
//            fokus = mViewRepassword;
//            cancel = true;
//        }
//        /* Jika cancel true, variable fokus mendapatkan fokus. Jika false, kembali
//ke LoginActivity dan Set User dan Password untuk data yang terdaftar */
//        if (cancel){
//            fokus.requestFocus();
//        }else{
//            preferences.setRegisteredUser(getBaseContext(),user);
//            preferences.setRegisteredPass(getBaseContext(),password);
//            startActivity(new Intent(getBaseContext(),loginActivity.class));
//            finish();
//        }
//    }
//    /* True jika parameter password sama dengan parameter repassword */
//    private boolean cekPassword(String password, String repassword){
//        return password.equals(repassword);
//    }
//    /* True jika parameter user sama dengan data user yang terdaftar dari
//    Preferences */
//    private boolean cekUser(String user){
//        return user.equals(preferences.getRegisteredUser(getBaseContext()));
//    }
//    public void create(View v){
//        razia();
//    }
//    public void openlogin(){
//        Intent intent = new Intent(this,loginActivity.class);
//        startActivity(intent);}
//    }
