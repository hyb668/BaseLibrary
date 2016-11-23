package com.gosuncn.sample.common.bases;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.gosuncn.sample.common.ApplicationComponent;

import dagger.Component;

@PerPage
@Component(dependencies = ApplicationComponent.class, modules = PageModule.class)
public interface PageComponent {

    Activity activity();

    Fragment fragment();

}
