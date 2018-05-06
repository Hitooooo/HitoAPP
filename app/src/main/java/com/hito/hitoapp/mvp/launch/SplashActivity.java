package com.hito.hitoapp.mvp.launch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hito.hitoapp.R;

/**
 * 广告也，可设置每次进入时是否有爱心小提示
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
