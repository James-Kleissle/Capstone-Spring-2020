//Katelynn Tafoya 01-08-20
//This is the code to select what they wish to delete. This code will have to be put in place once the partial wipes are complete. 
package com.example.cleansweepandsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class PartialProperties extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partial_properties);

        Button buttonhome = findViewById(R.id.buttonhome);
        buttonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWelcomeActivity();
                }
            });
        }
        public void openWelcomeActivity(){
            Intent homeIntent = new Intent(this, WelcomeActivity.class);
            startActivity(homeIntent);
    }
}


//There was an update to this code that can be found below..... 
//Katelynn 1/24/20
//I did not want to completely scratch the code above in case something doesn't work. So, if you would like to try the new code it can 
// be found below. 

package com.example.cleansweepandsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PartialProperties extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partial_properties);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWelcomeActivity();
            }
        });
    Button button2 = findViewById(R.id.button2);
    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openContactRemover();
        }
    });

    }
    public void openContactRemover() {
        Intent removerIntent = new Intent(this, ContactRemover.class);
        startActivity(removerIntent);
    }


    public void openWelcomeActivity() {
        Intent homeIntent = new Intent(this, WelcomeActivity.class);
        startActivity(homeIntent);
    }
}
