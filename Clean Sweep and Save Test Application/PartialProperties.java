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
