package com.gosuncn.sample.module.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.gosuncn.core.ui.widget.ToolbarExtend;
import com.gosuncn.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToolbarExtendActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    ToolbarExtend toolbar;
    @BindView(R.id.rg_gravity)
    RadioGroup rgGravity;
    @BindView(R.id.rg_size)
    RadioGroup rgSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_extend);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rgGravity.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i){
                case R.id.rb_left:
                    setGravity(Gravity.LEFT);
                    break;
                case R.id.rb_center:
                    setGravity(Gravity.CENTER);
                    break;
                case R.id.rb_right:
                    setGravity(Gravity.RIGHT);
                    break;
            }
        });
        rgGravity.check(R.id.rb_left);
        rgSize.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i){
                case R.id.rb_16:
                    setSize(R.dimen.dp_16);
                    break;
                case R.id.rb_24:
                    setSize(R.dimen.dp_24);
                    break;
                case R.id.rb_48:
                    setSize(R.dimen.dp_48);
                    break;
            }
        });
        rgSize.check(R.id.rb_16);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setGravity(int gravity) {
        toolbar.setTitleGravity(gravity);
    }

    private void setSize(int size) {
        toolbar.setDrawableSize(getResources().getDimensionPixelSize(size));
    }

}
