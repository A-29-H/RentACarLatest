package com.example.rentacar.gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import java.util.HashMap;
import java.util.Map;

public class CustomerSignUp extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth auth= FirebaseAuth.getInstance();
    EditText txtCustomerName;
    EditText txtCustomerMob;
    EditText txtCustomerCnic;
    EditText txtCustomerPass;
    EditText txtCustomerRePass;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up);
        txtCustomerName = findViewById(R.id.txtCustomerName);
        txtCustomerMob = findViewById(R.id.txtCustomerMob);
        txtCustomerCnic = findViewById(R.id.txtCustomerCnic);
        txtCustomerPass = findViewById(R.id.txtCustomerPass);
        txtCustomerRePass = findViewById(R.id.txtCustomerRePass);

    }
    public void customerSignUp(View view) {

        String customerName = txtCustomerName.getText().toString();
        String customerMob = txtCustomerMob.getText().toString();
        String customerCnic = txtCustomerCnic.getText().toString();
        String customerPass = txtCustomerPass.getText().toString();
        String customerRePass = txtCustomerRePass.getText().toString();
        if (customerPass.equals(customerRePass)) {

            Map<String,Object> customer = new HashMap<>();
            customer.put("name",customerName.trim());
            customer.put("number",customerMob.trim());
            customer.put("cnic",customerCnic.trim());
            db.collection("Customer").document(customerCnic.trim()).set(customer).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (customerName.contains("@customer.com")){
                        auth.createUserWithEmailAndPassword(customerName.trim(),customerPass.trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(getApplicationContext(),"Customer SignedUp Sucessfully",Toast.LENGTH_LONG).show();
                                finish();
                            }
                        });
                    }
                }

            });



        }
        else
        {
            Toast.makeText(this, "Password do not matched", Toast.LENGTH_SHORT).show();
        }
    }

    public void home(View view){
        finish();

    }

}