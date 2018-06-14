package com.hito.chatlib.mvp;

/**
 * description ：Present 祖宗
 *
 * @author : mht
 * @date : 18-6-14 下午9:52
 */
public interface IPresent<V> {
    void attachV(V v);

    void detachV();
}
