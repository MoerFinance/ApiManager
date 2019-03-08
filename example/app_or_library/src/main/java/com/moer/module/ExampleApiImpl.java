package com.moer.module;

import android.content.Context;
import android.content.Intent;

import com.moer.api.ApiImpl;
import com.moer.base.IExampleApi;

@ApiImpl(IExampleApi.class)
public class ExampleApiImpl implements IExampleApi {
    @Override
    public void startExampleActivity(Context context) {
        context.startActivity(new Intent(context, ExampleActivity.class));
    }
}
