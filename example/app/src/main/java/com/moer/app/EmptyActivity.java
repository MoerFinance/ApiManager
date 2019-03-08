package com.moer.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.moer.api.ApiManager;
import com.moer.base.IExampleApi;
import com.moer.example.apimanager.R;

public class EmptyActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.enter).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.enter:
                IExampleApi exampleApi = ApiManager.getInstance().getApi(IExampleApi.class);
                exampleApi.startExampleActivity(this);
                break;
        }
    }
}
