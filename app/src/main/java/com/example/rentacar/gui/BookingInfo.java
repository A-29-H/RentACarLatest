package com.example.rentacar.gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.rentacar.Entity.BookingCar;
import com.example.rentacar.Entity.Car;
import com.example.rentacar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class BookingInfo extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText editTxtUEmail;
    EditText editTxtCName;
    EditText editTxtCNumber;
    EditText editTxtUAccNo;
    EditText editTxtCDays;
    Spinner spinnerBookingInfo;
    ArrayList<BookingCar> list = new ArrayList<>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_info);
        editTxtUEmail = findViewById(R.id.editTextUEmail);
        editTxtCName = findViewById(R.id.editTextCName);
        editTxtCNumber = findViewById(R.id.editTextCNumber);
        editTxtUAccNo = findViewById(R.id.editTextUAccNo);
        editTxtCDays = findViewById(R.id.editTextCDays);
        spinnerBookingInfo = findViewById(R.id.spinnerBookingInfo);
        editTxtUEmail.setEnabled(false);
        editTxtCName.setEnabled(false);
        editTxtCNumber.setEnabled(false);
        editTxtUAccNo.setEnabled(false);
        editTxtCDays.setEnabled(false);
        db.collection("Booking").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot document:task.getResult()){
                        String name = document.get("carName").toString();
                        String number = document.get("carNumber").toString();
                        String model = document.get("carModel").toString();
                        String rent = document.get("carRent").toString();
                        String username = document.get("userName").toString();
                        String days = document.get("days").toString();
                        String accNo = document.get("accNo").toString();
                        String status = document.get("status").toString();
                        list.add(new BookingCar(name,model,number,Integer.parseInt(rent),username,Integer.parseInt(days),Integer.parseInt(accNo),status));

                    }
                    loadSpinner();
                }
            }


        });
    }
    public  void loadSpinner(){
        ArrayAdapter<BookingCar> adapterFrom = new ArrayAdapter<BookingCar>(this  , android.R.layout.simple_spinner_item , list);
        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinnerBookingInfo.setAdapter(adapterFrom);
       spinnerBookingInfo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BookingCar obj = (BookingCar) spinnerBookingInfo.getSelectedItem();

                editTxtUEmail.setText(obj.getUserName());
                editTxtCName.setText(obj.getCarName());
                editTxtCNumber.setText(obj.getCarNumber());
                editTxtUAccNo.setText(Integer.toString(obj.getAccNo()));
                editTxtCDays.setText(Integer.toString(obj.getDays()));



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void approve(View view){
        BookingCar obj = (BookingCar) spinnerBookingInfo.getSelectedItem();
        DocumentReference doc = db.collection("Booking").document(obj.getUserName());
        doc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    db.collection("Booking").document(obj.getUserName()).update("status", "Approve").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            finish();
                        }
                    });
                }
            }
        });

    }
    public void reject(View view){
        BookingCar obj = (BookingCar) spinnerBookingInfo.getSelectedItem();
        DocumentReference doc = db.collection("Booking").document(obj.getUserName());
        doc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    db.collection("Booking").document(obj.getUserName()).update("status", "Reject").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            finish();
                        }
                    });
                }
            }
        });
    }
    public void back(View view){
        finish();
    }
}
