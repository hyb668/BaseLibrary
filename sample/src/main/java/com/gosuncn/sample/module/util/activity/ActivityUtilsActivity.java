package com.gosuncn.sample.module.util.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.gosuncn.core.util.app.ActivityUtils;
import com.gosuncn.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityUtilsActivity extends UtilBaseActivity {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv)
    TextView tvAboutActivity;

    private String packageName;
    private String className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_util);
        ButterKnife.bind(this);
        initViews();
    }

    @Override
    protected void initViews() {
        super.initViews();
        packageName = this.getPackageName();
        className = packageName + ".module.ui.activity.CircleImageViewActivity";
        btn.setText("launch activity");
        tvAboutActivity.setText("Is this activity exists: " + ActivityUtils.isActivityExists(this, packageName, className)
                + "\ngetLauncherActivity: " + ActivityUtils.getLauncherActivity(this, packageName)
        );
    }

    @OnClick(R.id.btn)
    void onClick() {
        ActivityUtils.launchActivity(this, packageName, className);
    }

}
