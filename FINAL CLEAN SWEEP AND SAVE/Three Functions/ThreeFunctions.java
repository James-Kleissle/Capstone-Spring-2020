package com.example.cleansweepsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThreeFunctions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_functions);

        Button partial = findViewById(R.id.partial);
        partial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPartialWipe();
            }
        });
        Button unin = findViewById(R.id.unin);
        unin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSelfUninstall();
            }
        });

        Button phone = findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhoneVerification();
            }
        });
    }
    public void openPartialWipe(){
        Intent partIntent = new Intent(this, PartialWipe.class);
        startActivity(partIntent);
    }

    public void openSelfUninstall(){
        Intent uniIntent = new Intent(this, SelfUninstall.class);
        startActivity(uniIntent);
    }

    public void openPhoneVerification(){
        Intent phoneIntent = new Intent (this, PhoneVerification.class);
        startActivity(phoneIntent);
    }
}
