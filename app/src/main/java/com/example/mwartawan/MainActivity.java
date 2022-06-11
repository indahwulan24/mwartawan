package com.example.mwartawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

//import com.example.mwartawan.utils.SessionManager;
//import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

//    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

//        Stetho.initializeWithDefaults(this);
//        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
//        startActivity(intent);
//        finish();
    }
}