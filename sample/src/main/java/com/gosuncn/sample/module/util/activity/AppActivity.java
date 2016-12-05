package com.gosuncn.sample.module.util.activity;

import com.gosuncn.sample.R;
import com.gosuncn.sample.common.SampleApplication;
import com.gosuncn.sample.module.main.activity.AnActivity;
import com.gosuncn.sample.module.main.adapter.AnAdapter;

public class AppActivity extends AnActivity {

    private final String ACTIVITY_UTILS = SampleApplication.getAppContext().getResources().getString(R.string.activity_utils);
    private final String HANDLER = SampleApplication.getAppContext().getResources().getString(R.string.handler);
    private String[] itemTitle = new String[]{ACTIVITY_UTILS,HANDLER};

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
                    gotoActivity(ActivityUtilsActivity.class);
                    break;
                case 1:
                    gotoActivity(HandlerActivity.class);
                    break;
            }
        });
    }

}
