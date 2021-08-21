package com.example.optverification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class dashboard extends AppCompatActivity {
    String phoneNumber;
    Button sellerbutton, buyerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        sellerbutton = findViewById(R.id.sellerbutton);
        buyerbutton = findViewById(R.id.buyerbutton);
        sellerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber = getIntent().getStringExtra("mobileNumber");
                storeNewSellerData();
                // take to empty dashboard
                Intent intent = new Intent(getApplicationContext(), homeScreen.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        buyerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber = getIntent().getStringExtra("mobileNumber");
                storeNewBuyerData();
                Intent intent = new Intent(getApplicationContext(), homeScreen.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private void storeNewBuyerData() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("buyers");
        UserHelperClass helperClass = new UserHelperClass(phoneNumber, "NULL");
        reference.setValue(helperClass);
    }

    private void storeNewSellerData() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("sellers");
        UserHelperClass helperClass = new UserHelperClass(phoneNumber, "NULL");
        reference.setValue(helperClass);
    }
}