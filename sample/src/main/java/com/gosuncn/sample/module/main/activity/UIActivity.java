package com.gosuncn.sample.module.main.activity;

import com.gosuncn.sample.R;
import com.gosuncn.sample.common.SampleApplication;
import com.gosuncn.sample.module.main.adapter.AnAdapter;
import com.gosuncn.sample.module.ui.activity.ViewActivity;
import com.gosuncn.sample.module.ui.activity.WidgetActivity;

public class UIActivity extends AnActivity {

    private final String WIDGET = SampleApplication.getAppContext().getResources().getString(R.string.widget);
    private final String VIEW = SampleApplication.getAppContext().getResources().getString(R.string.view);
    private final String ADAPTER = SampleApplication.getAppContext().getResources().getString(R.string.adapter);
    private final String LISTENER = SampleApplication.getAppContext().getResources().getString(R.string.listener);
    private String[] itemTitle = new String[]{WIDGET,VIEW,ADAPTER,LISTENER};

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
                    gotoActivity(WidgetActivity.class);
                    break;
                case 1:
                    gotoActivity(ViewActivity.class);
                    break;
            }
        });
    }

}
