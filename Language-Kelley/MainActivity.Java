package com.hfad.language;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

    }

    Button changLang = findViewById(R.id.changeMyLang);
    changeLang.setOnClickListener(new View.OnClickListener) {
        @Override
        public void onClick(view View) {
        /* shows AlertDialog that displays a list of languages and select one */
        showChangeLanguageDialog();
    }
    }

    private void showChangeLanguageDialog() {
        //array of languages that will display in an alert dialog
        final String[] listItems = {"Español", "Gaeilge", "English"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    //spanish
                    setLocale("es");
                    recreate();
                } else if (i == 1) {
                    //Irish
                    setLocale("iri");
                    recreate();
                } else if (i == 2) {
                    //English
                    setLocale("en");
                    recreate();
                }

                //dismiss the alert dialog when lang is selected
                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();

        mDialog.show();

    }

    private void setLocale(String lang) {
                Locale locale = new Locale(lang);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
                editor.putString("My_Lang", lang);
                editor.apply();
            }
            public void loadLocale() {
                SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
                String language = prefs.getString("My_Lang", "");
                setLocale(language);
        }

    }
