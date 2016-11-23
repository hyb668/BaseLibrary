package com.gosuncn.sample.common.bases;
/**
 * @author Tong
 * @time 2016/11/22
 * @apiNote
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;

public abstract class SampleFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((SampleApplication) getActivity().getApplication()).component());
    }

    public abstract void inject(ApplicationComponent appComponent);

}
