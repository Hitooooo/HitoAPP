package com.hito.hitoapp.ui.launch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.hito.chatlib.net.ApiSubscriber;
import com.hito.chatlib.net.MApi;
import com.hito.chatlib.net.NetError;
import com.hito.hitoapp.R;
import com.hito.hitoapp.model.GankResults;
import com.hito.hitoapp.net.Api;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 广告也，可设置每次进入时是否有爱心小提示
 */
public class SplashActivity extends AppCompatActivity  {

    @BindView(R.id.animation_view)
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {

    }

}
