//worked on by James Kleissle 2/24/2020
package com.example.phoneverificationdatabase;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Spinner mSpinner;
    TextView mOutputSpinnerTv;
    //options to be displayed in spinner
    String[] mOptions = {"Select Phone Version", "Android 10.0 (Q)", "Android 9 (Pie)", "Android 8.1 (Oreo)", "Android8.0 (Oreo)", "Android 7.1.1 (Nougat)", "Android 7.1 (Nougat)", "Android 7.0 (Nougat)", "Android 6.0 (Marshmallow)",
            "Android 5.1 (Lollipop)", "Android 5.0 (Lollipop)", "Android 4.4 (KitKat)", "Android 4.3 (Jelly Bean)",
            "Android 4.2.2 (Jelly Bean)", "Android 4.2 (Jelly Bean)", "Android 4.1.1 ( Jelly Bean)", "Android 4.1 (Jelly Bean)",
            "Android 4.0.4 (Ice Cream Sandwich)", "Android 4.0.3c(Ice Cream Sandwich", "Android 4.0.2 (Ice Cream Sandwich)," +
            "Android 4.0.1 (Ice Cream Sandwich", "Android 4.0 (Ice Cream Sandwich)", "Android 3.2 (HoneyComb)", "Android 3.1 (HoneyComb)",
            "Android 3.0 (HoneyComb)", "Android 2.3.4 (Gingerbread)", "Android 2.3.3 (Gingerbread)", "Android 2.3.2 (Gingerbread)",
            "Android 2.3.1 (Gingerbread)", "Android 2.3 (Gingerbread)", "Android 2.2 (Froyo)", "Android 2.1 (Eclair)",
            "Android 2.0.1 (Eclair)", "Android 2.0 (Eclair)", "Android 1.6 (Donut)", "Android 1.5 (Cupcake)", "Android 1.1",
            "Android 1.0"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = findViewById(R.id.spinner);
        mOutputSpinnerTv = findViewById(R.id.outputSpinnerTv);

        //Creating the ArrayAdapter instance having the list of options
        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mOptions);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //setting the ArrayAdapter data on the Spinner
        mSpinner.setAdapter(aa);

        //spinner item click handler
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //METHOD 1: Get text from selected item's position & set it to TextView
                //mOutputSpinnerTv.setText(parent.getItemAtPosition(position).toString());

                //METHOD 2: Get the position of item selected, & perform specific task
                if (position==0){
                    mOutputSpinnerTv.setText("Please Select a Phone Version from the list above...");
                }
                if (position==1){
                    mOutputSpinnerTv.setText("This version is still supported!");
                }
                if (position==2){
                    mOutputSpinnerTv.setText("This version is still supported!");
                }
                if (position==3){
                    mOutputSpinnerTv.setText("This version is still supported!");
                }
                if (position==4) {
                    mOutputSpinnerTv.setText("This version is still supported!");
                }
                if (position==5) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==6) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==7) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==8) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==9) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==10) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==11) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==12) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==13) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==14) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==15) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==16) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==17) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==18) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==19) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==20) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==21) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==22) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==23) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==24) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==25) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==26) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==27) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==28) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==29) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==30) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==31) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==32) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==33) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==34) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==35) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
                if (position==36) {
                    mOutputSpinnerTv.setText("This Version is not supported!");
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
