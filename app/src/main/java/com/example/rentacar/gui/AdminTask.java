package com.example.rentacar.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rentacar.R;

public class AdminTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_task);
    }
    public void carInfo(View view){

        startActivity(new Intent(this, CarInfo.class));
    }
    public void bookingInfo(View view){

        startActivity(new Intent(this, BookingInfo.class));
    }
    public void logout(View view){

        finish();
    }
}