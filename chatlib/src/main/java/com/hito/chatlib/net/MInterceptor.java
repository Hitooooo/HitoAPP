package com.hito.chatlib.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 拦截器，实现在请求前请求后对请求体和返回体进行处理
 * @author MHT
 */
public class MInterceptor implements Interceptor {
    RequestHandler handler;

    public MInterceptor(RequestHandler handler) {
        this.handler = handler;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (handler != null) {
            request = handler.onBeforeRequest(request, chain);
        }
        Response response = chain.proceed(request);
        if (handler != null) {
            Response tmp = handler.onAfterRequest(response, chain);
            if (tmp != null) {
                return tmp;
            }

        }
        return response;
    }
}
