package com.hfad.retrieve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    //This code below was added automatically by the build
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Added below for button to be identified by an ID and for the OS to be ready for when a user clicks, then it will open the next screen
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                opendbActivity2();
            }
        });
    }
    // Called when the user taps the Send button
    public void opendbActivity2(){
        Intent intent = new Intent(this, retrieve2activity.class);
        startActivity(intent);
    }
}
