//Worked on by Katelynn 12-30-19
package com.example.buttonactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openButtoneActivity2();
            }
        });
    }

    public void openButtoneActivity2(){
        Intent intent = new Intent(this, ButtoneActivity2.class);
        startActivity(intent);
    }
}
