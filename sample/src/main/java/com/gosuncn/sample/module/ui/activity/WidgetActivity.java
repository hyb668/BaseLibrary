package com.gosuncn.sample.module.ui.activity;

import com.gosuncn.sample.R;
import com.gosuncn.sample.common.SampleApplication;
import com.gosuncn.sample.module.main.activity.AnActivity;
import com.gosuncn.sample.module.main.adapter.AnAdapter;

public class WidgetActivity extends AnActivity {

    private final String CIRCLE_IMAGE_VIEW = SampleApplication.getAppContext().getResources().getString(R.string.circle_image_view);
    private final String CUSTOM_TOOLBAR = SampleApplication.getAppContext().getResources().getString(R.string.custom_toolbar);
    private final String RECYCLER_VIEW_DIVIDER = SampleApplication.getAppContext().getResources().getString(R.string.recycler_view_divider);
    private final String RECYCLER_VIEW_GRID_SPACE = SampleApplication.getAppContext().getResources().getString(R.string.recycler_view_grid_space);
    private final String RECYCLER_VIEW_LINEAR_SPACE = SampleApplication.getAppContext().getResources().getString(R.string.recycler_view_linear_space);
    private final String RESIZE_DRAWABLE_CHECKBOX = SampleApplication.getAppContext().getResources().getString(R.string.resize_drawable_checkbox);
    private final String EDIT_TEXT_EXTEND = SampleApplication.getAppContext().getResources().getString(R.string.edit_text_extend);
    private String[] itemTitle = new String[]{CIRCLE_IMAGE_VIEW,CUSTOM_TOOLBAR,RECYCLER_VIEW_DIVIDER,
                        RECYCLER_VIEW_GRID_SPACE,RECYCLER_VIEW_LINEAR_SPACE,RESIZE_DRAWABLE_CHECKBOX,
                        EDIT_TEXT_EXTEND};

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
                    gotoActivity(CircleImageViewActivity.class);
                    break;
                case 1:
                    gotoActivity(ToolbarExtendActivity.class);
                    break;
                case 2:
                    gotoActivity(RecyclerViewDividerActivity.class);
                    break;
                case 3:
                    gotoActivity(RecyclerViewGridSpaceActivity.class);
                    break;
                case 4:
                    gotoActivity(RecyclerViewLinearSpaceActivity.class);
                    break;
                case 5:
                    gotoActivity(ResizeDrawableCheckBoxActivity.class);
                    break;
                case 6:
                    gotoActivity(EditTextExtendActivity.class);
                    break;
            }
        });
    }

}
