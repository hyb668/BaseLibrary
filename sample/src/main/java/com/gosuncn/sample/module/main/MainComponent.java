package com.gosuncn.sample.module.main;

import com.gosuncn.sample.common.ApplicationComponent;
import com.gosuncn.sample.common.bases.PageComponent;
import com.gosuncn.sample.common.bases.PageModule;
import com.gosuncn.sample.common.bases.PerPage;

import dagger.Component;

/**
 * @author Tong
 * @time 2016/11/22
 * @apiNote
 */
@PerPage
@Component(
        dependencies = ApplicationComponent.class,
        modules = {PageModule.class, MainModule.class}
)
public interface MainComponent extends PageComponent {


}
