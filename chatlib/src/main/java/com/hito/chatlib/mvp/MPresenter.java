package com.hito.chatlib.mvp;

import java.lang.ref.WeakReference;

/**
 * description ：
 *
 * @author : mht
 * @date : 18-6-20 下午10:37
 */
public class MPresenter<V extends IView> implements IPresent<V> {
    private WeakReference<V> v;

    @Override
    public void attachV(V view) {
        v = new WeakReference<V>(view   );
    }

    @Override
    public void detachV() {
        if (v.get() != null) {
            v.clear();
        }
        v = null;
    }

    protected V getV() {
        if (v == null || v.get() == null) {
            throw new IllegalStateException("v can not be null");
        }
        return v.get();
    }
}
