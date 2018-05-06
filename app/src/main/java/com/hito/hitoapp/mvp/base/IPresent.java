package com.hito.hitoapp.mvp.base;

/**
 * 基接口
 * Created by dream on 2018/05/06.
 */
public interface IPresent<V> {
    void attachView(V view);

    void detachView();
}
