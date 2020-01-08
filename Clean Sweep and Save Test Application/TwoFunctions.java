//Katelynn Tafoya 01-08-20
//This code is for the selection of which function we need to go to. 
package com.example.cleansweepandsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TwoFunctions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_functions);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPartialWipe();
                }
            });
        // New Code that was added
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v){
            openPhoneVerification();
            }
        });
        //
        //New Code that was added
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                openWelcomeActivity();
            }
        });
        //
        }
        public void openPartialWipe(){
            Intent partialIntent = new Intent(this, PartialWipe.class);
            startActivity(partialIntent);
        }

        //New Code
        public void openPhoneVerification(){
            Intent phoneIntent = new Intent(this, PhoneVerification.class);
            startActivity(phoneIntent);
        }
        //
        //New Code
        public void openWelcomeActivity(){
            Intent homeIntent = new Intent(this, WelcomeActivity.class);
            startActivity(homeIntent);
        }
        //
    }
