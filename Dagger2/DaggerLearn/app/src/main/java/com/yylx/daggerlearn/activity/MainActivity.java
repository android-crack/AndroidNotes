package com.yylx.daggerlearn.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yylx.daggerlearn.DApplication;
import com.yylx.daggerlearn.R;
import com.yylx.daggerlearn.data.User;
import com.yylx.daggerlearn.data.UserType;
import com.yylx.daggerlearn.di.components.DaggerMainAtyComponent;
import com.yylx.daggerlearn.di.components.MainAtyComponent;

import javax.inject.Inject;

import dagger.Lazy;


public class MainActivity extends Activity {

    private MainAtyComponent mainAtyComponent;

    @Inject
    Lazy<User> lazyUser;

    @Inject
    @UserType(type = UserType.Type.A)
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainAtyComponent = DaggerMainAtyComponent.builder()
                .appComponent(((DApplication) getApplication()).getAppComponent())
                .build();
        mainAtyComponent.inject(this);
        //        component = Dagg.builder().applicationComponent(((DApplication) getApplication()).getAppComponent())
        //                .activityModule(new ActivityModule(this))
        //                .build();
        //        component.injectActivity(this);
        setContentView(R.layout.activity_main);
        //        ((DApplication) getApplication()).getAppComponent().getToastUtil().showToast("WTF!!");
        ((DApplication) getApplication()).getAppComponent().getToastUtil().showToast(mUser.toString());
        lazyUser.get();
    }

    public void sayHello(View v) {
        TextView textView = (TextView) findViewById(R.id.textView);
        EditText editText = (EditText) findViewById(R.id.editText);
        textView.setText("hello, " + editText.getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
