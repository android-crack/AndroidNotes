package com.yylx.daggerlearn.di.modules;

import com.yylx.daggerlearn.activity.LoginActivity;
import com.yylx.daggerlearn.presenter.ILoginPresenter;
import com.yylx.daggerlearn.presenter.LoginPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zqj on 2016/6/3 16:02.
 */
@Module
public class LoginModule {
    private LoginActivity mContext;

    public LoginModule(LoginActivity activity) {
        mContext = activity;
    }

    @Provides
    public ILoginPresenter provideLoginPresenter() {
        return new LoginPresenterImpl(mContext);
    }
}
