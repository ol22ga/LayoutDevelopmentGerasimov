package com.example.layoutdevelopmentgerasimov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class successfulRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_registration);


    }

    public void  onAuth (View v) {
        startActivity(new Intent(successfulRegistration.this, authorization_activity.class
        ));
    }
}