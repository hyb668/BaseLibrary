package com.gosuncn.sample.common.bases;
/**
 * @author Tong
 * @time 2016/11/22
 * @apiNote
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((SampleApplication) getApplication()).component());
    }

    public abstract void inject(ApplicationComponent appComponent);

}
