package com.moer.module;

import android.content.Context;
import android.widget.Toast;

import com.moer.api.ApiImpl;
import com.moer.base.IUserApi;

@ApiImpl(IUserApi.class)
public class UserApiImpl implements IUserApi {
    @Override
    public void login(Context context) {
        Toast.makeText(context, "user module login() called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUserDescription() {
        return "user's description from user module";
    }
}
