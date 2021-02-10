package com.example.rentacar.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rentacar.R;

public class ContactInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
    }
    public void back(View view){
        finish();

    }
    public void openDial(View view){
        try {
            Uri u = Uri.parse("tel:03062856471");
            Intent intent = new Intent(Intent.ACTION_DIAL, u);
            startActivity(intent);


        }
        catch (Exception e) {
            Toast.makeText(this, "Some Error Occur While opening Dialer", Toast.LENGTH_SHORT).show();
        }
    }

}