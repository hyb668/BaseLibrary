package com.gosuncn.sample.common.bases;

import android.app.Application;

import com.gosuncn.core.common.util.UrlInterceptor;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * @author Tong
 * @time 2016/11/22
 * @apiNote
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Application application();
    UrlInterceptor urlInterceptor();
    Retrofit retrofit();

}