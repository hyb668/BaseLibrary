package com.gosuncn.sample.module.main.activity;

import com.gosuncn.sample.R;
import com.gosuncn.sample.common.SampleApplication;
import com.gosuncn.sample.module.main.adapter.AnAdapter;
import com.gosuncn.sample.module.util.activity.AppActivity;
import com.gosuncn.sample.module.util.activity.FunctionActivity;

public class UtilActivity extends AnActivity {

    private final String APP = SampleApplication.getAppContext().getResources().getString(R.string.m_app);
    private final String DEVICE = SampleApplication.getAppContext().getResources().getString(R.string.device);
    private final String FORMAT = SampleApplication.getAppContext().getResources().getString(R.string.convert);
    private final String IMAGE = SampleApplication.getAppContext().getResources().getString(R.string.image);
    private final String SECURITY = SampleApplication.getAppContext().getResources().getString(R.string.security);
    private final String STORAGE = SampleApplication.getAppContext().getResources().getString(R.string.storage);
    private final String STRING = SampleApplication.getAppContext().getResources().getString(R.string.string);
    private final String VIEW = SampleApplication.getAppContext().getResources().getString(R.string.view);
    private final String FUNCTION = SampleApplication.getAppContext().getResources().getString(R.string.function);
    private String[] itemTitle = new String[]{APP,DEVICE,FORMAT,IMAGE,SECURITY,STORAGE,STRING,VIEW, FUNCTION};

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
                    gotoActivity(AppActivity.class);
                    break;
                case 8:
                    gotoActivity(FunctionActivity.class);
                    break;
            }
        });
    }

}
