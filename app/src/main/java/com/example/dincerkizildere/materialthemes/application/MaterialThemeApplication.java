package com.example.dincerkizildere.materialthemes.application;

import android.app.Application;

import com.example.dincerkizildere.materialthemes.log.LogUtils;

import timber.log.Timber;

public class MaterialThemeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize logging first to log all operations
        LogUtils.initLoggingUtilities();
        Timber.v(LogUtils.METHOD_ONLY);
    }
}