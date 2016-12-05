package com.gosuncn.sample.module.util.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class UtilBaseActivity extends AppCompatActivity {

    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
