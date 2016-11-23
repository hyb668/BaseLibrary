package com.gosuncn.sample.common.bases;

import android.app.Activity;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;

@Module
public class PageModule {

    private Activity activity;
    private Fragment fragment;

    public PageModule(Activity activity) {
        this.activity = activity;
    }

    public PageModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    Activity activity() {
        return activity;
    }

    @Provides
    Fragment fragment() {
        return fragment;
    }

}
