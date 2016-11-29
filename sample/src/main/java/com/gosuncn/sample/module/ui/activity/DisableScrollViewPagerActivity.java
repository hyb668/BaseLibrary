package com.gosuncn.sample.module.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.gosuncn.core.ui.view.DisableScrollViewPager;
import com.gosuncn.sample.R;
import com.gosuncn.sample.module.ui.adapter.PagerAdapter;
import com.gosuncn.sample.module.ui.fragment.ItemFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisableScrollViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    DisableScrollViewPager vp;
    @BindView(R.id.tl)
    TabLayout tl;

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disable_scroll_view_pager);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        vp.setOffscreenPageLimit(4);
        createFragments(4);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),fragments);
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);
    }

    private void createFragments(int i) {
        for (int j = 0; j < i; j++) {
            fragments.add(ItemFragment.newInstance("Item: "+j));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scroll, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                break;
            case R.id.action_scrollable:
                item.setChecked(!item.isChecked());
                vp.setScrollable(item.isChecked());
                break;
            case R.id.action_smooth_scroll:
                item.setChecked(!item.isChecked());
                vp.setSmoothScroll(item.isChecked());
                break;
        }
        return true;
    }

}
