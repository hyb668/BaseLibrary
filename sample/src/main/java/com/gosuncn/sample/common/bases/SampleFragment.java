package com.gosuncn.sample.common.bases;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.gosuncn.sample.common.ApplicationComponent;
import com.gosuncn.sample.common.SampleApplication;

public abstract class SampleFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((SampleApplication) getActivity().getApplication()).component());
    }

    public abstract void inject(ApplicationComponent appComponent);

}
