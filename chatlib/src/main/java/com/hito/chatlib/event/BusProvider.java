package com.hito.chatlib.event;

/**
 * description ：
 *
 * @author : mht
 * @date : 18-6-14 下午10:57
 */
public class BusProvider {
    private static RxBusImpl bus;

    public static RxBusImpl getBus() {
        if (bus == null) {
            synchronized (BusProvider.class) {
                if (bus == null) {
                    bus = RxBusImpl.get();
                }
            }
        }
        return bus;
    }

}
