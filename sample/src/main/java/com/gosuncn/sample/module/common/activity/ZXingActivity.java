package com.gosuncn.sample.module.common.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gosuncn.core.common.bases.BaseActivity;
import com.gosuncn.core.common.zxing.activity.CaptureActivity;
import com.gosuncn.core.common.zxing.encoding.EncodingUtils;
import com.gosuncn.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZXingActivity extends BaseActivity {

    @BindView(R.id.tv_showResult)
    TextView tvShowResult;
    @BindView(R.id.et_text)
    EditText etText;
    @BindView(R.id.cb_logo)
    CheckBox cbLogo;
    @BindView(R.id.img_shouw)
    ImageView imgShouw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.btn_scan, R.id.btn_make})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_scan:
                startActivityForResult(new Intent(this, CaptureActivity.class), 0);
                break;
            case R.id.btn_make:
                String input = etText.getText().toString();
                if (TextUtils.isEmpty(input)) {
                    showShortToast("输入不能为空");
                } else {
                    Bitmap qrCode = EncodingUtils.createQRCode(input, 500, 500, cbLogo.isChecked() ?
                            BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher) : null);
                    imgShouw.setImageBitmap(qrCode);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                String result = bundle.getString("result");
                tvShowResult.setText(result);
            }
        }

    }


}
