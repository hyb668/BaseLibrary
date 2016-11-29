package com.gosuncn.sample.module.main.activity;

import com.gosuncn.sample.R;
import com.gosuncn.sample.common.SampleApplication;
import com.gosuncn.sample.module.main.adapter.AnAdapter;

public class MainActivity extends AnActivity {

    private final String UI = SampleApplication.getAppContext().getResources().getString(R.string.ui);
    private final String COMMON = SampleApplication.getAppContext().getResources().getString(R.string.common);
    private final String UTIL = SampleApplication.getAppContext().getResources().getString(R.string.util);
    private String[] itemTitle = new String[]{UI,COMMON,UTIL};

    @Override
    protected void initViews() {
        super.initViews();
        //添加Adapter和Listener
        AnAdapter adapter = new AnAdapter(itemTitle);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener((v, position) -> {
            switch (position){
                case 0:
                    gotoActivity(UIActivity.class);
                    break;
            }
        });
    }


}
