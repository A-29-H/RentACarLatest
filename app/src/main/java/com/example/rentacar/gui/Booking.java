package com.example.rentacar.gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.rentacar.Entity.Car;
import com.example.rentacar.Entity.Helper;
import com.example.rentacar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Booking extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText editTxtCarRent;
    EditText editTxtAccNo;
    Spinner txtSpinnerShowCarList;
    ArrayList<Car> list = new ArrayList<>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        editTxtCarRent = findViewById(R.id.editTxtdays);
        editTxtAccNo = findViewById(R.id.editTxtAccNo);
        txtSpinnerShowCarList = findViewById(R.id.txtSpinnerShowCarList);

        db.collection("Car").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.get("name").toString();
                        String number = document.get("number").toString();
                        String model = document.get("model").toString();
                        String rent = document.get("rent").toString();
                        list.add(new Car(name, model, number, Integer.parseInt(rent)));

                    }
                    loadSpinner();
                }
            }
        });


    }
    public  void loadSpinner(){
        ArrayAdapter<Car> adapterFrom = new ArrayAdapter<Car>(this  , android.R.layout.simple_spinner_item , list);
        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txtSpinnerShowCarList.setAdapter(adapterFrom);
    }
    public void book(View view){
        Car obj = (Car) txtSpinnerShowCarList.getSelectedItem();
        int days = Integer.parseInt(editTxtCarRent.getText().toString());
        int accNo = Integer.parseInt(editTxtAccNo.getText().toString());
        String username = Helper.username;
        Map<String, Object> booking = new HashMap<>();
        booking.put("carName", obj.getCarName());
        booking.put("carModel", obj.getCarModel());
        booking.put("carNumber", obj.getCarNumber());
        booking.put("carRent", obj.getCarRent());
        booking.put("userName", username);
        booking.put("days", days);
        booking.put("accNo", accNo);
        booking.put("status", "Reserved");

        db.collection("Booking").document(username).set(booking).addOnCompleteListener(new OnCompleteListener<Void>() {
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
