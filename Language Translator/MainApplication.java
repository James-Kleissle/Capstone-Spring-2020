package com.example.androidrealtimelang;

import android.app.Application;
import android.content.Context;

import com.example.androidrealtimelang.Helper.LocaleHelper;

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
