package com.hito.hitoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hito.chatlib.net.ApiSubscriber;
import com.hito.chatlib.net.MApi;
import com.hito.chatlib.net.NetError;
import com.hito.hitoapp.model.GankResults;
import com.hito.hitoapp.net.Api;

/**
 * 广告也，可设置每次进入时是否有爱心小提示
 */
public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_test).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                Api.getGankService().getGankData("Android", 10, 0)
                        .compose(MApi.<GankResults>getApiTransformer())
                        .compose(MApi.<GankResults>getScheduler())
                        .subscribe(new ApiSubscriber<GankResults>() {
                            @Override
                            public void onNext(GankResults gankResults) {

                            }

                            @Override
                            public void onError(Throwable e) {
                                super.onError(e);
                            }

                            @Override
                            protected void onFail(NetError error) {

                            }
                        });
                break;
                default:
                    break;
        }
    }
}
