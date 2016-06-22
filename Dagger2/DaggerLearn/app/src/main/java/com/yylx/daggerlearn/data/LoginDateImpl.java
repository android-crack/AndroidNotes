package com.yylx.daggerlearn.data;

import android.text.TextUtils;

import com.yylx.daggerlearn.presenter.ILoginPresenter;

/**
 * Created by zqj on 2016/6/3 15:22.
 */
public class LoginDateImpl implements ILoginPresenter.ILoginDate {
    @Override
    public void login(String name, String password, OnLoginFinishedListener listener) {
        if (TextUtils.isEmpty(name)) {
            listener.onUsernameError();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
            return;
        }
        listener.onSuccess();
    }
}
