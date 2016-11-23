package com.gosuncn.sample.common.bases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gosuncn.sample.common.ApplicationComponent;
import com.gosuncn.sample.common.SampleApplication;

public abstract class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((SampleApplication) getApplication()).component());
    }

    public abstract void inject(ApplicationComponent appComponent);

}
