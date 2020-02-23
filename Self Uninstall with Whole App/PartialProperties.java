package com.example.remover;

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
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSelfDestruction();
            }
        });

    }
    public void openContactRemover() {
        Intent removerIntent = new Intent(this, ContactRemover.class);
        startActivity(removerIntent);
    }
    public void openSelfDestruction(){
     Intent destroyIntent = new Intent(this, SelfDestruction.class);
     startActivity(destroyIntent);
    }
    public void openWelcomeActivity() {
        Intent homeIntent = new Intent(this, WelcomeActivity.class);
        startActivity(homeIntent);
    }
}
