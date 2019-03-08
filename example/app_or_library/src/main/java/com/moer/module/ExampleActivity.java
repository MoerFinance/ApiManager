package com.moer.module;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.moer.api.ApiManager;
import com.moer.base.IUserApi;
import com.moer.example.module.R;

public class ExampleActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        findViewById(R.id.login).setOnClickListener(getContext());
        findViewById(R.id.user_description).setOnClickListener(getContext());
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        IUserApi userApi = ApiManager.getInstance().getApi(IUserApi.class);
        if (i == R.id.login) {
            userApi.login(getContext());
        } else if (i == R.id.user_description) {
            if (userApi.isPresent()) {
                Toast.makeText(getContext(), userApi.getUserDescription(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private ExampleActivity getContext() {
        return this;
    }
}
