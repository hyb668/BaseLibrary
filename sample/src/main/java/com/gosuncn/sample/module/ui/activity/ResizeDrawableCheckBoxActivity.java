package com.gosuncn.sample.module.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.gosuncn.core.ui.widget.ResizeDrawableCheckBox;
import com.gosuncn.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResizeDrawableCheckBoxActivity extends AppCompatActivity {

    @BindView(R.id.cb)
    ResizeDrawableCheckBox cb;
    @BindView(R.id.rg_size)
    RadioGroup rgSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resize_drawable_check_box);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    private void setSize(int size) {
        cb.setDrawableSize(getResources().getDimensionPixelSize(size));
    }

}
