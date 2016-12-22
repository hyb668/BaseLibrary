package com.gosuncn.sample.module.main.activity;

import com.gosuncn.sample.R;
import com.gosuncn.sample.common.SampleApplication;
import com.gosuncn.sample.module.common.activity.ZXingActivity;
import com.gosuncn.sample.module.main.adapter.AnAdapter;

public class CommonActivity extends AnActivity {

    private final String ZXING = SampleApplication.getAppContext().getResources().getString(R.string.zxing);
    private String[] itemTitle = new String[]{ZXING};

    @Override
    protected void initViews() {
        super.initViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //添加Adapter和Listener
        AnAdapter adapter = new AnAdapter(itemTitle);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener((v, position) -> {
            switch (position){
                case 0:
                    gotoActivity(ZXingActivity.class);
                    break;
            }
        });
    }

}
