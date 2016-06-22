package com.yylx.daggerlearn.data;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by zqj on 2016/5/31 16:46.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface UserType {
    enum Type {A, B}

    Type type() default Type.A;
}
