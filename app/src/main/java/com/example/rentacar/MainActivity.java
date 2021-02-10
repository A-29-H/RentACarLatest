package com.example.rentacar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rentacar.gui.AdminPage;
import com.example.rentacar.gui.ContactInfo;
import com.example.rentacar.gui.CustomerPage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void customer(View view){
        Toast.makeText(this,"customer call", Toast.LENGTH_LONG  ).show();
        startActivity(new Intent(this, CustomerPage.class)) ;
    }

    public void admin(View view){
        Toast.makeText(this,"admin call", Toast.LENGTH_LONG  ).show();
        startActivity(new Intent(this, AdminPage.class)) ;

    }
    public void contactInfo(View view){
        Toast.makeText(this,"contact call", Toast.LENGTH_LONG  ).show();
        startActivity(new Intent(this, ContactInfo.class)) ;

    }












}