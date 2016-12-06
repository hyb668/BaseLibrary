package com.gosuncn.sample.module.util.activity;

import com.gosuncn.sample.R;
import com.gosuncn.sample.common.SampleApplication;
import com.gosuncn.sample.module.main.activity.AnActivity;
import com.gosuncn.sample.module.main.adapter.AnAdapter;

public class FunctionActivity extends AnActivity {

    private final String HANDLER = SampleApplication.getAppContext().getResources().getString(R.string.handler);
    private String[] itemTitle = new String[]{HANDLER};

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
                    gotoActivity(HandlerActivity.class);
                    break;
            }
        });
    }

}
