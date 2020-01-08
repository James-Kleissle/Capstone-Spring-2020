//Katelynn Tafoya 01-08-20
//This code is to ensure the person wants to do a partial wipe like in the mock up from 401 
package com.example.cleansweepandsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PartialWipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partial_wipe);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               openPartialProperties();
           }
        });
         Button button2 = findViewById(R.id.button2);
         button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openWelcomeActivity();
             }
         });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWelcomeActivity();
            }
        });
    }
    public void openPartialProperties(){
        Intent propertiesIntent = new Intent(this, PartialProperties.class);
        startActivity(propertiesIntent);
    }
    public void openWelcomeActivity(){
        Intent homeIntent = new Intent(this, WelcomeActivity.class);
        startActivity(homeIntent);
    }
}
