package com.moer.base;

import android.content.Context;

import com.moer.api.IApi;

public interface IUserApi extends IApi {
    void login(Context context);

    String getUserDescription();
}
