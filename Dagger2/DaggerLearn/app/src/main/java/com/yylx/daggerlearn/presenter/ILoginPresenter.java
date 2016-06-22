package com.yylx.daggerlearn.presenter;

/**
 * Created by zqj on 2016/6/3 15:19.
 */
public interface ILoginPresenter {
    void validateLoginInfo(String username, String password);

    void onDestroy();

    interface ILoginView {
        void showProgress();

        void hideProgress();

        void navigateToHome();

        void onUsernameError();

        void onPasswordError();
    }

    interface ILoginDate {
        interface OnLoginFinishedListener {
            void onUsernameError();

            void onPasswordError();

            void onSuccess();
        }

        void login(String name, String password, OnLoginFinishedListener listener);
    }
}
