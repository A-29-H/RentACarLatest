package com.example.rentacar.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rentacar.R;

public class CarInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);
    }
    public void addCar(View view){

        startActivity(new Intent(this,AddCar.class ));
    }
    public void viewCar(View view){
        startActivity(new Intent(this, ViewCar.class));
    }
    public void searchCar(View view){

        startActivity(new Intent(this,E_S_D_Car.class ));
    }
    public void back(View view){

        finish();
    }
}