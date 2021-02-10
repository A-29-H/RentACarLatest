package com.example.rentacar.gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.rentacar.Entity.Car;
import com.example.rentacar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ViewCar extends AppCompatActivity {
    EditText txtViewCarName;
    EditText txtViewCarModel;
    EditText txtViewCarNumber;
    EditText txtViewCarRent;
    Spinner txtSpinnerCarList;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<Car> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_car);
        txtViewCarName = findViewById(R.id.txtViewCarName);
        txtViewCarModel = findViewById(R.id.txtViewCarModel);
        txtViewCarNumber = findViewById(R.id.txtViewCarNumber);
        txtViewCarRent = findViewById(R.id.txtViewCarRent);
        txtSpinnerCarList = findViewById(R.id.txtSpinnerCarList);

        txtViewCarName.setEnabled(false);
        txtViewCarModel.setEnabled(false);
        txtViewCarNumber.setEnabled(false);
        txtViewCarRent.setEnabled(false);
        db.collection("Car").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot document:task.getResult()){
                        String name = document.get("name").toString();
                        String number = document.get("number").toString();
                        String model = document.get("model").toString();
                        String rent = document.get("rent").toString();
                        list.add(new Car(name,model,number,Integer.parseInt(rent)));

                    }
                    loadSpinner();
                }
            }
        });

    }
    public  void loadSpinner(){
        ArrayAdapter<Car> adapterFrom = new ArrayAdapter<Car>(this  , android.R.layout.simple_spinner_item , list);
        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txtSpinnerCarList.setAdapter(adapterFrom);
    }
    public void display(View view){
        Car obj = (Car)txtSpinnerCarList.getSelectedItem();
        if(obj != null){
            txtViewCarName.setText(obj.getCarName());
            txtViewCarModel.setText(obj.getCarModel());
            txtViewCarNumber.setText(obj.getCarNumber());
            txtViewCarRent.setText(String.valueOf(obj.getCarRent()));
        }
    }
    public void back(View view) {
        finish();
    }
}