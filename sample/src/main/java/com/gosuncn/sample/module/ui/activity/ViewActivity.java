package com.gosuncn.sample.module.ui.activity;

import com.gosuncn.sample.R;
import com.gosuncn.sample.common.SampleApplication;
import com.gosuncn.sample.module.main.activity.AnActivity;
import com.gosuncn.sample.module.main.adapter.AnAdapter;

public class ViewActivity extends AnActivity {

    private final String BLUR_FRAME_LAYOUT = SampleApplication.getAppContext().getResources().getString(R.string.blur_frame_layout);
    private final String DISABLE_SCROLL_VIEWPAGER = SampleApplication.getAppContext().getResources().getString(R.string.disable_scroll_viewpager);
    private final String SQUARE_LAYOUT = SampleApplication.getAppContext().getResources().getString(R.string.square_layout);
    private String[] itemTitle = new String[]{BLUR_FRAME_LAYOUT,DISABLE_SCROLL_VIEWPAGER,SQUARE_LAYOUT};

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
                    gotoActivity(BlurFrameLayoutActivity.class);
                    break;
                case 1:
                    gotoActivity(DisableScrollViewPagerActivity.class);
                    break;
                case 2:
                    gotoActivity(SquareLayoutActivity.class);
                    break;
            }
        });
    }

}
