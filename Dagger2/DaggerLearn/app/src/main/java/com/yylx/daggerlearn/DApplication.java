package com.yylx.daggerlearn;

import android.app.Application;

import com.yylx.daggerlearn.di.components.AppComponent;
import com.yylx.daggerlearn.di.components.DaggerAppComponent;
import com.yylx.daggerlearn.di.modules.AppModule;

/**
 * Created by zqj on 2016/5/31 15:20.
 */
public class DApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return component;
    }
}
