package com.hito.hitoapp;

import android.app.Application;

import com.hito.chatlib.net.MApi;
import com.hito.chatlib.net.NetError;
import com.hito.chatlib.net.NetProvider;
import com.hito.chatlib.net.RequestHandler;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by dream on 2018/05/06.
 *
 * @author Dream
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MApi.registerProvider(new NetProvider() {

            @Override
            public Interceptor[] configInterceptors() {
                return new Interceptor[0];
            }

            @Override
            public void configHttps(OkHttpClient.Builder builder) {

            }

            @Override
            public CookieJar configCookie() {
                return null;
            }

            @Override
            public RequestHandler configHandler() {
                return null;
            }

            @Override
            public long configConnectTimeoutMills() {
                return 0;
            }

            @Override
            public long configReadTimeoutMills() {
                return 0;
            }

            @Override
            public boolean configLogEnable() {
                return true;
            }

            @Override
            public boolean handleError(NetError error) {
                return false;
            }

            @Override
            public boolean dispatchProgressEnable() {
                return false;
            }
        });
    }
}

