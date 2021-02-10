package com.example.rentacar.gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rentacar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AdminPage extends AppCompatActivity {
    EditText txtAdminUserName;
    EditText txtAdminPass;
    FirebaseAuth auth= FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        txtAdminUserName = findViewById(R.id.txtCustomerName);
        txtAdminPass = findViewById(R.id.txtCustomerMob);
    }
    public void signIn(View view) {
        String username = txtAdminUserName.getText().toString();
        String password = txtAdminPass.getText().toString();
        if(username.contains("@admin.com")){
            auth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        startActivity(new Intent(getApplicationContext(), AdminTask.class));
                    }
                }
            });
        }
    }
    public void home(View view){
        finish();

    }

}