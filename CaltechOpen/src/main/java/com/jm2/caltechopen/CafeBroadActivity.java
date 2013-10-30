package com.jm2.caltechopen;

import android.app.ActionBar;
import android.os.Bundle;

public class CafeBroadActivity extends NavigateHomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_broad);

        // Enable the user to navigate back using the action bar
        ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }





}
