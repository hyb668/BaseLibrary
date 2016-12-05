package com.gosuncn.sample.module.util;

import com.gosuncn.sample.common.ApplicationComponent;
import com.gosuncn.sample.common.bases.PageComponent;
import com.gosuncn.sample.common.bases.PageModule;
import com.gosuncn.sample.common.bases.PerPage;

import dagger.Component;

/**
 * @author Tong
 * @time 2016/12/1
 * @apiNote
 */
@PerPage
@Component(
        dependencies = ApplicationComponent.class,
        modules = {PageModule.class, UtilModule.class}
)
public interface UtilComponent extends PageComponent {


}
