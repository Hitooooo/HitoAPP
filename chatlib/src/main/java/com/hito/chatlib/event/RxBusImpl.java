package com.hito.chatlib.event;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * description ：
 *
 * @author : mht
 * @date : 18-6-14 下午10:58
 */
public class RxBusImpl implements IBus {

    private FlowableProcessor<Object> bus = null;

    private RxBusImpl() {
        bus = PublishProcessor.create().toSerialized();
    }

    public static RxBusImpl get() {
        return Holder.instance;
    }

    @Override
    public void register(Object object) {

    }

    @Override
    public void unregister(Object object) {

    }

    @Override
    public void post(IEvent event) {
        bus.onNext(event);
    }

    @Override
    public void postSticky(IEvent event) {

    }

    public <T extends IEvent> Flowable<T> toFlowable(Class<T> eventType) {
        return bus.ofType(eventType).onBackpressureBuffer();
    }

    private static class Holder {
        private static final RxBusImpl instance = new RxBusImpl();
    }
}
