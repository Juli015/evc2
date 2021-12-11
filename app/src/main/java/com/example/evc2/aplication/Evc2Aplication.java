package com.example.evc2.aplication;

import android.app.AppComponentFactory;
import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class Evc2Aplication extends Application {
    private static   Evc2Aplication instance;
    private static Context appContext;

    public static Evc2Aplication getInstance() {return instance; }
    public static Context getAppContext() {return appContext; }

    public void setAppContext(Context mAppContext) { this.appContext = mAppContext; }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
