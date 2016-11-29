package com.gosuncn.sample.module.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.gosuncn.core.common.bases.BaseActivity;
import com.gosuncn.core.ui.widget.RecyclerViewLinearSpace;
import com.gosuncn.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Tong
 * @time 2016/11/24
 * @apiNote
 */
public class AnActivity extends BaseActivity {

    @BindView(R.id.rv)
    public RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an);
        ButterKnife.bind(this);
        initViews();
    }

    protected void initViews() {
        //设置RecyclerView布局
        rv.setHasFixedSize(true);//优化布局性能
        LinearLayoutManager layoutManager = new LinearLayoutManager(rv.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.addItemDecoration(new RecyclerViewLinearSpace(40));
        rv.setLayoutManager(layoutManager);
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
