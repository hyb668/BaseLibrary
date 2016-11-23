package com.gosuncn.sample.common;

import android.app.Application;
import android.content.Context;


public class SampleApplication extends Application {

    private ApplicationComponent appComponent;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        context = appComponent.application();
    }

    public ApplicationComponent component() {
        return appComponent;
    }

    public static Context getAppContext() {
        return context;
    }

}


