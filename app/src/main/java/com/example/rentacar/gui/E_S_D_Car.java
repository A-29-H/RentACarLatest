package com.example.rentacar.gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.rentacar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class E_S_D_Car extends AppCompatActivity {
    EditText txtSearchCar;
    EditText txtEditCarName;
    EditText txtEditCarModel;
    EditText txtEditCarNumber;
    EditText txtEditCarRent;
    ImageButton btnCarEdit;
    ImageButton btnCarDelete;
    Button btnCarUpdate;
    FirebaseAuth auth= FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e__s__d__car);
        txtSearchCar= findViewById(R.id.txtSearchCar);
        txtEditCarName= findViewById(R.id.txtEditCarName);
        txtEditCarModel= findViewById(R.id.txtEditCarModel);
        txtEditCarNumber= findViewById(R.id.txtEditCarNumber);
        txtEditCarRent= findViewById(R.id.txtEditCarRent);
        btnCarEdit= (ImageButton) findViewById(R.id.btnCarEdit);
        btnCarDelete= (ImageButton) findViewById(R.id.btnCarDelete);
        btnCarUpdate= (Button) findViewById(R.id.btnCarUpdate);

        txtEditCarName.setVisibility(View.INVISIBLE);
        txtEditCarModel.setVisibility(View.INVISIBLE);
        txtEditCarNumber.setVisibility(View.INVISIBLE);
        txtEditCarRent.setVisibility(View.INVISIBLE);
        btnCarEdit.setVisibility(View.INVISIBLE);
        btnCarDelete.setVisibility(View.INVISIBLE);
        btnCarUpdate.setVisibility(View.INVISIBLE);

        txtEditCarName.setEnabled(false);
        txtEditCarModel.setEnabled(false);
        txtEditCarNumber.setEnabled(false);
        txtEditCarRent.setEnabled(false);
    }
    public void searchCar(View view){
        String search= txtSearchCar.getText().toString();
        Boolean isAvailable = true;
        DocumentReference doc = db.collection("Car").document(search);
        doc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot doc = task.getResult();
                if(doc.exists()){
                    txtEditCarName.setVisibility(View.VISIBLE);
                    txtEditCarModel.setVisibility(View.VISIBLE);
                    txtEditCarNumber.setVisibility(View.VISIBLE);
                    txtEditCarRent.setVisibility(View.VISIBLE);
                    btnCarEdit.setVisibility(View.VISIBLE);
                    btnCarDelete.setVisibility(View.VISIBLE);

                    txtEditCarName.setText(doc.get("name").toString());
                    txtEditCarModel.setText(doc.get("model").toString());
                    txtEditCarNumber.setText(doc.get("number").toString());
                    txtEditCarRent.setText(doc.get("rent").toString());
                }
            }
        });

    }
    public void edit(View view){
        txtEditCarName.setEnabled(true);
        txtEditCarModel.setEnabled(true);
        txtEditCarNumber.setEnabled(true);
        txtEditCarRent.setEnabled(true);
        btnCarUpdate.setVisibility(View.VISIBLE);
    }
    public void delete(View view){
        db.collection("Car").document(txtSearchCar.getText().toString()).delete();
        finish();
    }
    public void update(View view){
        db.collection("Car").document(txtSearchCar.getText().toString()).delete();
        Map<String,Object> car = new HashMap<>();

        car.put("name", txtEditCarName.getText().toString());
        car.put("model", txtEditCarModel.getText().toString());
        car.put("number", txtEditCarNumber.getText().toString());
        car.put("rent", txtEditCarRent.getText().toString());
        db.collection("Car").document(txtEditCarNumber.getText().toString()).set(car).addOnCompleteListener(new OnCompleteListener<Void>() {
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