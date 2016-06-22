package com.yylx.daggerlearn.presenter;

import android.os.Handler;

import com.yylx.daggerlearn.data.LoginDateImpl;

/**
 * Created by zqj on 2016/6/3 15:05.
 */
public class LoginPresenterImpl implements ILoginPresenter, ILoginPresenter.ILoginDate.OnLoginFinishedListener {

    private ILoginView mLoginView;
    private ILoginDate mLoginDate;

    private Handler mHandler = new Handler();

    public LoginPresenterImpl(ILoginView loginView) {
        mLoginView = loginView;
        mLoginDate = new LoginDateImpl();
    }

    @Override
    public void validateLoginInfo(String username, String password) {
        mLoginDate.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
        mLoginDate = null;
    }

    @Override
    public void onUsernameError() {
        mLoginView.onUsernameError();
        mLoginView.hideProgress();
    }

    @Override
    public void onPasswordError() {
        mLoginView.onPasswordError();
        mLoginView.hideProgress();

    }

    @Override
    public void onSuccess() {
        mLoginView.showProgress();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoginView.navigateToHome();
            }
        }, 2000);
    }
}