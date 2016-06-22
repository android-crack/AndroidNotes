package com.yylx.daggerlearn.di.components;

import com.yylx.daggerlearn.activity.LoginActivity;
import com.yylx.daggerlearn.di.modules.LoginModule;
import com.yylx.daggerlearn.di.scopes.PerActivity;

import dagger.Component;

/**
 * Created by zqj on 2016/6/3 15:53.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = LoginModule.class)
public interface LoginAtyComponent {
    void inject(LoginActivity activity);
}
