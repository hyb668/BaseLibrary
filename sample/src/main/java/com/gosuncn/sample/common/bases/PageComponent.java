package com.gosuncn.sample.common.bases;
/**
 * @author Tong
 * @time 2016/11/22
 * @apiNote
 */

import android.app.Activity;
import android.support.v4.app.Fragment;

import dagger.Component;

@PerPage
@Component(dependencies = ApplicationComponent.class, modules = PageModule.class)
public interface PageComponent {

    Activity activity();

    Fragment fragment();

}
