package com.yylx.daggerlearn.di.modules;

import android.content.Context;

import com.yylx.daggerlearn.ToastUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zqj on 2016/5/31 15:16.
 */
@Module
public class AppModule {
    Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    public ToastUtil provideToastUtil() {
        return new ToastUtil(mContext);
    }
}
