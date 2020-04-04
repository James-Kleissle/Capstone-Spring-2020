package com.example.cleansweepsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpanThreeFunc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_span_three_func);

        Button partial = findViewById(R.id.partial);
        partial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpanPartialWipe();
            }
        });

        Button phone = findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpanPhoneVerification();
            }
        });

        Button unin = findViewById(R.id.unin);
        unin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpanSelfUninstall();
            }
        });
    }
    public void openSpanPartialWipe(){
    Intent partIntent = new Intent(this, SpanPartialWipe.class);
    startActivity(partIntent);
    }

    public void openSpanPhoneVerification(){
        Intent phoneIntent = new Intent(this, SpanPhoneVerification.class);
        startActivity(phoneIntent);
    }

    public void openSpanSelfUninstall(){
        Intent uniIntent = new Intent (this, SpanSelfUninstall.class);
        startActivity(uniIntent);
    }
}
