package com.rubenskj.core.entity;

import com.rubenskj.core.interfaces.ICallback;
import com.rubenskj.core.interfaces.ISubscribe;

import java.util.HashMap;
import java.util.Map;

public class SubscribeHandler implements ISubscribe {

    public static final Map<String, ISubscribe> QUEUE = new HashMap();

    @Override
    public void handle(ICallback callback) {
        if (callback == null) {
            return;
        }

        callback.run();
    }

    @Override
    public void connect(String key) {
        QUEUE.put(key, this);
    }
}
