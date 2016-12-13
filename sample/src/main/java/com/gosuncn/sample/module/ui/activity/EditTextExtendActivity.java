package com.gosuncn.sample.module.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.text.InputType;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.gosuncn.core.ui.widget.EditTextExtend;
import com.gosuncn.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditTextExtendActivity extends AppCompatActivity {

    @BindView(R.id.et)
    EditTextExtend et;
    @BindView(R.id.rg_size)
    RadioGroup rgSize;

    boolean show = true;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_extend);
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
        et.setOnRightIconClickListener(() -> {
            if(show){
                et.setRightIcon(getResources().getDrawable(R.drawable.vector_visibility_off));
                et.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }else {
                et.setRightIcon(getResources().getDrawable(R.drawable.vector_visibility));
                et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            show = !show;
        });
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
        et.setDrawableSize(getResources().getDimensionPixelSize(size));
    }

}
