//Katelynn 12-28-19

//This part already comes when you create any new project....
package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

//Here we are setting the intial pause time for the splash screen
    private static int SPLASH_TIME_OUT = 2000;

//This part already comes when you create any new project....
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        
        new Handler() .postDelayed(new Runnable(){
            @Override
 //using public void run because a runnable object was used.            
            public void run() {
 //Here we are essentially telling the app how to start the activity. This is 
 //becuase Intent is used when performing an action. 
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
