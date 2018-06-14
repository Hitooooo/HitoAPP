package com.hito.chatlib.mvp;

import android.os.Bundle;
import android.view.View;

/**
 * description ：定义View的基本操作
 *
 * @author : mht
 * @date : 18-6-14 下午9:54
 */
public interface IView<P> {
    void bindUI(View rootView);

    void bindEvent();

    void initData(Bundle savedInstanceState);

    int getLayoutId();

    P newP();

    boolean useEventBus();
}
