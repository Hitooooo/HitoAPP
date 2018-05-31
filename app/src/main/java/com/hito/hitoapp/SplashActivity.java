package com.hito.hitoapp;

import android.app.Activity;
import android.os.Bundle;

/**
 * 广告也，可设置每次进入时是否有爱心小提示
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
