package com.gosuncn.sample.module.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.gosuncn.core.ui.widget.RecyclerViewGridSpace;
import com.gosuncn.sample.R;
import com.gosuncn.sample.module.main.adapter.AnAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewGridSpaceActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    String[] strs;
    GridLayoutManager gridLayoutManager;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    RecyclerViewGridSpace space;

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
        AnAdapter adapter = new AnAdapter(strs);
        rv.setAdapter(adapter);
        //设置RecyclerView布局
        rv.setHasFixedSize(true);//优化布局性能
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        gridLayoutManager = new GridLayoutManager(rv.getContext(),2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        space = new RecyclerViewGridSpace(2,10,true);
        rv.addItemDecoration(space);
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
        getMenuInflater().inflate(R.menu.menu_grid, menu);
        getMenuInflater().inflate(R.menu.menu_orientation, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        RecyclerView.LayoutManager layoutManager;
        switch (id){
            case android.R.id.home:
                finish();
                break;
            case R.id.action_grid:
                rv.setLayoutManager(gridLayoutManager);
                break;
            case R.id.action_staggered_grid:
                rv.setLayoutManager(staggeredGridLayoutManager);
                break;
            case R.id.action_vertical:
                layoutManager = rv.getLayoutManager();
                gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
                staggeredGridLayoutManager.setOrientation(StaggeredGridLayoutManager.VERTICAL);
                if(layoutManager instanceof GridLayoutManager){
                    rv.setLayoutManager(gridLayoutManager);
                }else{
                    rv.setLayoutManager(staggeredGridLayoutManager);
                }
                break;
            case R.id.action_horizontal:
                layoutManager = rv.getLayoutManager();
                gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
                staggeredGridLayoutManager.setOrientation(StaggeredGridLayoutManager.HORIZONTAL);
                if(layoutManager instanceof GridLayoutManager){
                    rv.setLayoutManager(gridLayoutManager);
                }else{
                    rv.setLayoutManager(staggeredGridLayoutManager);
                }
                break;
        }
        return true;
    }

}
