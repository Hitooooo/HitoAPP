package com.hito.hitoapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private String TAG = this.getClass().getSimpleName();
    @Test
    public void useAppContext() {
        // Context of the app under test.
        final Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.hito.hitoapp", appContext.getPackageName());
        observable.subscribe(mObserver);
    }

    // 练习RxJava
    // 观察者，警察
    Observer<String> mObserver = new Observer<String>(){
        @Override
        public void onCompleted() {
            Log.d(TAG, "It is completed");
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(String s) {
            Log.d(TAG, s);
        }
    };

    // 被观察者，小偷
    Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

        // 当被观察者（小偷）被警察（观察者）锁定，此方法会被调用
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("你被订阅了");
            subscriber.onNext("你被订阅了2");
            subscriber.onCompleted();
        }
    });
}
