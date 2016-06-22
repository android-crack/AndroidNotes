package com.yylx.daggerlearn;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zqj on 2016/5/31 15:24.
 */
public class ToastUtil {

    private Context mContext;

    public ToastUtil(Context context) {
        this.mContext = context;
    }

    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }
    public void showToast(int messageId) {
        Toast.makeText(mContext, messageId, Toast.LENGTH_LONG).show();
    }

}
