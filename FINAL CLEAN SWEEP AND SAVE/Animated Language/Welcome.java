package com.example.cleansweepsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tomer.fadingtextview.FadingTextView;

import java.util.concurrent.TimeUnit;

public class Welcome extends AppCompatActivity {
private FadingTextView fadingTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        fadingTextView = findViewById(R.id.fading_text_view);

        Button english = findViewById(R.id.english);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThreeFunctions();
            }
        });

        Button spanish = findViewById(R.id.spanish);
        spanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpanThreeFunc();
            }
        });
    }

        public void openThreeFunctions(){
            Intent threeIntent = new Intent(this, ThreeFunctions.class);
            startActivity(threeIntent);
        }

        public void openSpanThreeFunc(){
            Intent spanIntent = new Intent(this, SpanThreeFunc.class);
            startActivity(spanIntent);
        }
}
