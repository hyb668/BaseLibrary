package com.gosuncn.sample.common.bases;

import android.os.Bundle;

import com.gosuncn.core.common.bases.BaseFragment;
import com.gosuncn.sample.common.ApplicationComponent;
import com.gosuncn.sample.common.SampleApplication;

public abstract class SampleFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((SampleApplication) getActivity().getApplication()).component());
    }

    public abstract void inject(ApplicationComponent appComponent);

}
