package com.gosuncn.sample.common;

import android.app.Application;
import android.content.Context;

import com.gosuncn.core.common.logger.LogUtil;
import com.gosuncn.sample.BuildConfig;


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
        LogUtil.init(BuildConfig.DEBUG);
    }

    public ApplicationComponent component() {
        return appComponent;
    }

    public static Context getAppContext() {
        return context;
    }

}


