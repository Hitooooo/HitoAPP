package com.hito.chatlib.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hito.chatlib.XDroidConf;
import com.hito.chatlib.event.BusProvider;
import com.hito.chatlib.kit.KnifeKit;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.trello.rxlifecycle2.components.RxFragment;

import butterknife.Unbinder;

/**
 * description ：
 *
 * @author : mht
 * @date : 18-6-20 下午11:02
 */
public abstract class MFragment<P extends IPresent> extends RxFragment implements IView<P> {

    private LayoutInflater mLayoutInflater;
    private View mRootView;
    private Unbinder unbinder;
    private P p;
    private Activity context;
    private RxPermissions mRxPermissions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mLayoutInflater = inflater;
        if (mRootView == null && getLayoutId() > 0) {
            mRootView = inflater.inflate(getLayoutId(), null);
            bindUI(mRootView);
        } else {
            ViewGroup viewGroup = (ViewGroup) mRootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(mRootView);
            }
        }
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (useEventBus()) {
            BusProvider.getBus().register(this);
        }
        bindEvent();
        initData(savedInstanceState);
    }

    @Override
    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this, rootView);
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
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.context = (Activity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (useEventBus()) {
            BusProvider.getBus().unregister(this);
        }
        if (getP() != null) {
            getP().detachV();
        }
        p = null;
    }

    protected RxPermissions getRxPermissions() {
        mRxPermissions = new RxPermissions(getActivity());
        mRxPermissions.setLogging(XDroidConf.DEV);
        return mRxPermissions;
    }

    @Override
    public void bindEvent() {

    }
}