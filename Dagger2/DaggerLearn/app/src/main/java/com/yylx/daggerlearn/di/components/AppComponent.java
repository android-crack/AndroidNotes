package com.yylx.daggerlearn.di.components;

import android.content.Context;

import com.yylx.daggerlearn.ToastUtil;
import com.yylx.daggerlearn.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zqj on 2016/5/31 15:19.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context getContext();

    ToastUtil getToastUtil();
}
