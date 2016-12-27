package com.gosuncn.sample.module.util.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gosuncn.core.util.function.LocationUtils;
import com.gosuncn.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.gosuncn.core.util.function.LocationUtils.openGpsSettings;

public class LocationUtilsActivity extends UtilBaseActivity implements LocationUtils.OnLocationChangeListener {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv)
    TextView tvHandler;

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
        btn.setVisibility(View.GONE);
        tvHandler.setText("no message");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission();
        }else{
            locationEnable();
        }
    }

    @TargetApi(23)
    private void checkPermission(){
        if (this.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("本应用需要定位服务");
            builder.setMessage("请给予本应用定位权限");
            builder.setPositiveButton(android.R.string.ok, (dialog, which) ->  myRequestPermissions());
            builder.setNegativeButton(android.R.string.cancel,(dialog, which) -> finish());
            builder.setCancelable(false);
            builder.show();
        }
    }

    @TargetApi(23)
    public void myRequestPermissions() {
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    locationEnable();
                } else {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("功能受限");
                    builder.setMessage("由于定位权限未授予，无法进行相应功能");
                    builder.setPositiveButton(android.R.string.ok, (dialog, which) -> finish());
                    builder.setNegativeButton(android.R.string.cancel,(dialog, which) -> finish());
                    builder.setCancelable(false);
                    builder.show();
                }
                return;
            }
        }
    }

    private void locationEnable(){
        if(LocationUtils.isLocationEnabled(this)){
            LocationUtils.register(this,0,0,this);
        }else{
            new AlertDialog.Builder(this).setTitle("提示")
                    .setMessage("是否开启定位服务?")
                    .setPositiveButton(android.R.string.ok, (dialog, which) ->
                            openGpsSettings(this)
                    )
                    .setNegativeButton(android.R.string.cancel, (dialog, which) -> finish())
                    .setCancelable(false).show();
        }
    }


    @Override
    public void getLastKnownLocation(Location location) {
        showLocation(location);
    }

    @Override
    public void onLocationChanged(Location location) {
        showLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    private void showLocation(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        String currentPosition = "纬度 : " + latitude + "\n" + "经度 : " + longitude;
        tvHandler.setText(currentPosition);
    }

    @Override
    protected void onStop() {
        LocationUtils.unregister();
        super.onStop();
    }
}
