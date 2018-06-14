package com.hito.chatlib.event;

/**
 * description ：
 *
 * @author : mht
 * @date : 18-6-14 下午10:58
 */
public interface IBus {
    void register(Object object);

    void unregister(Object object);

    void post(IEvent event);

    void postSticky(IEvent event);


    interface IEvent {
        int getTag();
    }
}
