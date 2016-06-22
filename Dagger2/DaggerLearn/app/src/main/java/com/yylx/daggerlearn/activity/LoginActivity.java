package com.yylx.daggerlearn.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.yylx.daggerlearn.DApplication;
import com.yylx.daggerlearn.R;
import com.yylx.daggerlearn.di.components.DaggerLoginAtyComponent;
import com.yylx.daggerlearn.di.components.LoginAtyComponent;
import com.yylx.daggerlearn.di.modules.LoginModule;
import com.yylx.daggerlearn.presenter.ILoginPresenter;

import javax.inject.Inject;

/**
 * Created by zqj on 2016/6/3 14:58.
 */
public class LoginActivity extends Activity implements ILoginPresenter.ILoginView, View.OnClickListener {

    private LoginAtyComponent mComponent;

    @Inject
    public ILoginPresenter presenter;


    private ProgressBar progressBar;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mComponent = DaggerLoginAtyComponent
                .builder()
                .appComponent(((DApplication) getApplication()).getAppComponent())
                .loginModule(new LoginModule(this))
                .build();
        mComponent.inject(this);

        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onUsernameError() {
        ((DApplication) getApplication()).getAppComponent().getToastUtil().showToast(R.string.username_error);
        //        username.setError(getString(R.string.username_error));
    }

    @Override
    public void onPasswordError() {
        ((DApplication) getApplication()).getAppComponent().getToastUtil().showToast(R.string.password_error);
        //        password.setError(getString(R.string.password_error));
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        presenter.validateLoginInfo(username.getText().toString(), password.getText().toString());
    }
}
