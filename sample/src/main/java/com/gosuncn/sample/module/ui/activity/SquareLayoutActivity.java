package com.gosuncn.sample.module.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.gosuncn.sample.R;
import com.gosuncn.sample.module.ui.adapter.SquareAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SquareLayoutActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    String[] strs;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an);
        ButterKnife.bind(this);
        initViews();
    }

    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        createData(40);
        //添加Adapter和Listener
        SquareAdapter adapter = new SquareAdapter(strs);
        rv.setAdapter(adapter);
        //设置RecyclerView布局
        rv.setHasFixedSize(true);//优化布局性能
        gridLayoutManager = new GridLayoutManager(rv.getContext(),2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv.setLayoutManager(gridLayoutManager);
    }

    private void createData(int size){
        strs = new String[size];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = "Item: "+i;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_span_count,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                break;
            case R.id.action_count_2:
                item.setChecked(true);
                gridLayoutManager.setSpanCount(2);
                break;
            case R.id.action_count_3:
                item.setChecked(true);
                gridLayoutManager.setSpanCount(3);
                break;
        }
        return true;
    }
}
