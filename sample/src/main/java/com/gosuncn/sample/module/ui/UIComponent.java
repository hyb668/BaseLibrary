package com.gosuncn.sample.module.ui;

import com.gosuncn.sample.common.ApplicationComponent;
import com.gosuncn.sample.common.bases.PageComponent;
import com.gosuncn.sample.common.bases.PageModule;
import com.gosuncn.sample.common.bases.PerPage;

import dagger.Component;

/**
 * @author Tong
 * @time 2016/11/24
 * @apiNote
 */
@PerPage
@Component(
        dependencies = ApplicationComponent.class,
        modules = {PageModule.class, UIModule.class}
)
public interface UIComponent extends PageComponent {


}
