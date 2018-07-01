package com.hito.chatlib.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hito.chatlib.event.BusProvider;
import com.hito.chatlib.kit.KnifeKit;
import com.trello.rxlifecycle2.components.RxActivity;

import butterknife.Unbinder;

/**
 * description ：
 *
 * @author : mht
 * @date : 18-6-14 下午10:29
 */
public abstract class MActivity<P extends IPresent> extends RxActivity implements IView<P> {
    private Activity mActivity;
    private P p;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            bindUI(null);
            bindEvent();
        }
        initData(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (useEventBus()) {
            BusProvider.getBus().register(this);
        }
    }

    @Override
    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this);
    }

    @Override
    public void bindEvent() {

    }

    protected P getP() {
        if (p == null) {
            p = newP();
            if (p != null) {
                p.attachV(this);
            }
        }
        return p;
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            KnifeKit.unbind(unbinder);
        }
    }
}
