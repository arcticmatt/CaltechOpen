package com.jm2.caltechopen;

import android.app.ActionBar;
import android.os.Bundle;

public class ChandlerActivity extends NavigateHomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chandler);

        // Enable the user to navigate back using the action bar
        ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }




}
