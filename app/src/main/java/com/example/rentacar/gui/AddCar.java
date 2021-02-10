package com.example.rentacar.gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rentacar.Entity.Car;
import com.example.rentacar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddCar extends AppCompatActivity {
    EditText txtCarName;
    EditText txtCarModel;
    EditText txtCarNumber;
    EditText txtCarRent;
    FirebaseAuth auth= FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);


        txtCarName = findViewById(R.id.txtCarName);
        txtCarModel = findViewById(R.id.txtCarModel);
        txtCarNumber = findViewById(R.id.txtCarNumber);
        txtCarRent = findViewById(R.id.txtCarRent);

    }
    public void addCar(View view){
        String carName= txtCarName.getText().toString();
        String carModel= txtCarModel.getText().toString();
        String carNumber= txtCarNumber.getText().toString();
        int carRent= Integer.parseInt(txtCarRent.getText().toString());
        Car obj = new Car(carName, carModel, carNumber, carRent);
        Map<String,Object> car = new HashMap<>();
        car.put("name", carName);
        car.put("model", carModel);
        car.put("number", carNumber);
        car.put("rent", txtCarRent.getText().toString());
        db.collection("Car").document(carNumber).set(car).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
            }
        });




    }
    public void back(View view){
        finish();
    }

}