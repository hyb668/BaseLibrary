package com.gosuncn.sample.module.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gosuncn.core.common.bases.BaseFragment;
import com.gosuncn.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ItemFragment extends BaseFragment {

    @BindView(R.id.tv_fragment)
    TextView tvFragment;

    public static final String PARAM = "param";
    private String mParam;

    public ItemFragment() {
    }

    public static ItemFragment newInstance(String param) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putString(PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
        tvFragment.setText(mParam);
    }

    @OnClick(R.id.btn)
    void onClick(){
        showShortToast("Test");
    }
}
