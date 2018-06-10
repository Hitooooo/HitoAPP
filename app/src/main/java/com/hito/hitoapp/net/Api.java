package com.hito.hitoapp.net;

import com.hito.chatlib.net.MApi;

public class Api {
    public static final String API_BASE_URL = "http://gank.io/api/";

    private static GankService gankService;

    public static GankService getGankService() {
        if (gankService == null) {
            synchronized (Api.class) {
                if (gankService == null) {
                    gankService = MApi.getInstance().getRetrofit(API_BASE_URL, true).create(GankService.class);
                }
            }
        }
        return gankService;
    }
}
