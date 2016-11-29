package com.gosuncn.sample.module.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.gosuncn.core.ui.view.BlurFrameLayout;
import com.gosuncn.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class BlurFrameLayoutActivity extends AppCompatActivity {

    @BindView(R.id.fl)
    BlurFrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur_frame_layout);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnCheckedChanged(R.id.cb)
    void onChecked(boolean checked){
        if(checked) fl.setVisibility(View.VISIBLE);
        else fl.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
