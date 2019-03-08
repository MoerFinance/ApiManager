package com.moer.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.moer.module.ExampleActivity;

public class EmptyModuleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, ExampleActivity.class));
        finish();
    }
}
