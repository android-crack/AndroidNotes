package com.yylx.daggerlearn.di.modules;

import com.yylx.daggerlearn.data.User;
import com.yylx.daggerlearn.data.UserType;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zqj on 2016/5/31 16:49.
 */
@Module
public class MainAtyModule {

    @Provides
    @UserType(type = UserType.Type.A)
    public User provideUserA() {
        return new User("zqj", "1234");
    }

    @Provides
    @UserType(type = UserType.Type.B)
    public User provideUserB() {
        return new User("zqj", "1234", 18);

    }
}
