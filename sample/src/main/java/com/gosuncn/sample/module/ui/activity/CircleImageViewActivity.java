package com.gosuncn.sample.module.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.gosuncn.core.ui.widget.CircleImageView;
import com.gosuncn.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleImageViewActivity extends AppCompatActivity {

    @BindView(R.id.civ)
    CircleImageView civ;
    @BindView(R.id.rg_width)
    RadioGroup rgWidth;
    @BindView(R.id.rg_color)
    RadioGroup rgColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_view);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rgWidth.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i){
                case R.id.rb_1:
                    setWidth(R.dimen.dp_1);
                    break;
                case R.id.rb_8:
                    setWidth(R.dimen.dp_8);
                    break;
                case R.id.rb_16:
                    setWidth(R.dimen.dp_16);
                    break;
            }
        });
        rgWidth.check(R.id.rb_1);
        rgColor.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i){
                case R.id.rb_red:
                    setColor(R.color.color_material_red_500_primary);
                    break;
                case R.id.rb_green:
                    setColor(R.color.color_material_green_500);
                    break;
                case R.id.rb_blue:
                    setColor(R.color.color_material_blue_500);
                    break;
            }
        });
        rgColor.check(R.id.rb_red);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setWidth(int dp) {
        civ.setBorderWidth(getResources().getDimensionPixelOffset(dp));
    }

    private void setColor(int color) {
        civ.setBorderColor(getResources().getColor(color));
    }

}
