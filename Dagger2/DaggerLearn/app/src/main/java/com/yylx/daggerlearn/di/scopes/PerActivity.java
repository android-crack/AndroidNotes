package com.yylx.daggerlearn.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by niuxiaowei on 16/3/22.
 * copy from nxw's demo
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
