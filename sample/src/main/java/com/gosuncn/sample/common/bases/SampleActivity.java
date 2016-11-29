package com.gosuncn.sample.common.bases;

import android.os.Bundle;

import com.gosuncn.core.common.bases.BaseActivity;
import com.gosuncn.sample.common.ApplicationComponent;
import com.gosuncn.sample.common.SampleApplication;

public abstract class SampleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((SampleApplication) getApplication()).component());
    }

    public abstract void inject(ApplicationComponent appComponent);

}
