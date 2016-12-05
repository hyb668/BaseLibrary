package com.gosuncn.sample.module.util.activity;

import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import com.gosuncn.core.util.app.Handler;
import com.gosuncn.sample.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HandlerActivity extends UtilBaseActivity implements Handler.OnReceiveMessageListener {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv)
    TextView tvHandler;

    private Handler.Holder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_util);
        ButterKnife.bind(this);
        initViews();
        holder = new Handler.Holder(this);
    }

    @OnClick(R.id.btn)
    void onClick(){
        holder.sendEmptyMessageDelayed(0, 3000);
    }

    @Override
    protected void initViews() {
        super.initViews();
        btn.setText("Send Message");
        tvHandler.setText("no message");
    }

    @Override
    public void handlerMessage(Message msg) {
        tvHandler.setText("get_msg_after_3s");
    }
}
