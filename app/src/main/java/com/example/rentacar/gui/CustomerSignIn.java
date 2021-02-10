package com.example.rentacar.gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rentacar.Entity.Helper;
import com.example.rentacar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CustomerSignIn extends AppCompatActivity {

    EditText txtUserName;
    EditText txtUserPass;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_in);
        txtUserName = findViewById(R.id.txtUserName);
        txtUserPass = findViewById(R.id.txtUserPass);
        auth = FirebaseAuth.getInstance();
    }

    public void signIn(View view){
        Helper.username = txtUserName.getText().toString();
        startActivity(new Intent(getApplicationContext(), Booking.class));
        /*String userName= txtUserName.getText().toString();
        String userPass= txtUserPass.getText().toString();
        if(userName.contains("@customer.com")){
            auth.signInWithEmailAndPassword(userName,userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    txtUserName.setText(task.toString());
                    if(task.isSuccessful()){
                        txtUserName.setText("");
                        startActivity(new Intent(getApplicationContext(), AdminTask.class));

                        //addNewActivity
                        //com.google.android.gms.tasks.zzu@fedbc03

                    }
                }
            });
        }
*/
    }
    public void home(View view){

        finish();
    }

}