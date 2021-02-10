package com.example.rentacar.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rentacar.R;

public class CustomerPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);
    }
    public void signUp(View view)
    {
        startActivity(new Intent(this, CustomerSignUp.class));
    }
    public void signIn(View view){
        startActivity(new Intent(this, CustomerSignIn.class));
    }
    public void home(View view){
        finish();
    }
}