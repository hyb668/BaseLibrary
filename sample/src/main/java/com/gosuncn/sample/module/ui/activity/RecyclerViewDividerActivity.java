package com.gosuncn.sample.module.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.gosuncn.core.ui.widget.RecyclerViewLinearDivider;
import com.gosuncn.sample.R;
import com.gosuncn.sample.module.ui.adapter.UIAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewDividerActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    String[] strs;
    LinearLayoutManager layoutManager;
    RecyclerViewLinearDivider divider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an);
        ButterKnife.bind(this);
        initViews();
    }

    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        createData(10);
        //添加Adapter和Listener
        UIAdapter adapter = new UIAdapter(strs);
        rv.setAdapter(adapter);
        //设置RecyclerView布局
        rv.setHasFixedSize(true);//优化布局性能
        layoutManager = new LinearLayoutManager(rv.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        divider = new RecyclerViewLinearDivider(this,RecyclerViewLinearDivider.VERTICAL_LIST);
        rv.addItemDecoration(divider);
        rv.setLayoutManager(layoutManager);
    }

    private void createData(int size){
        strs = new String[size];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = "Item: "+i;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_orientation, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                break;
            case R.id.action_vertical:
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                divider.setOrientation(RecyclerViewLinearDivider.VERTICAL_LIST);
                break;
            case R.id.action_horizontal:
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                divider.setOrientation(RecyclerViewLinearDivider.HORIZONTAL_LIST);
                divider.setWidth(10);
                break;
        }
        return true;
    }

}
