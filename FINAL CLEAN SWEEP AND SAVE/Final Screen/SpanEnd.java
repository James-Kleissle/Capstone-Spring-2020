package com.example.cleansweepsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpanEnd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_span_end);

        Button home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThreeFunctions();
            }
        });
    }
    public void openThreeFunctions(){
        Intent homeIntent = new Intent(this, SpanThreeFunc.class);
        startActivity(homeIntent);
    }
}
