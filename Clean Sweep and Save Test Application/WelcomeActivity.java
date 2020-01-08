//Katelynn Tafoya 01/08/20
//This is the code for the home screen. 
package com.example.cleansweepandsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTwoFunctions();
            }
        });
    }

    public void openTwoFunctions() {
        Intent intent = new Intent (this, TwoFunctions.class);
        startActivity(intent);
    }
}
