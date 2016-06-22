package com.yylx.daggerlearn.di.components;

import com.yylx.daggerlearn.activity.MainActivity;
import com.yylx.daggerlearn.di.modules.MainAtyModule;
import com.yylx.daggerlearn.di.scopes.PerActivity;

import dagger.Component;

/**
 * Created by zqj on 2016/5/31 16:03.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = MainAtyModule.class)
public interface MainAtyComponent {
    void inject(MainActivity activity);
}
