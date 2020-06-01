package com.rubenskj.core.entity;

import com.rubenskj.core.interfaces.ICallback;
import com.rubenskj.core.interfaces.ISubscribe;

import java.util.UUID;

import static com.rubenskj.core.entity.SubscribeHandler.QUEUE;

public class Subscribe {
    private final String key;
    private final ICallback callback;

    public Subscribe(ICallback callback) {
        this.key = UUID.randomUUID().toString();
        this.callback = callback;
        new SubscribeHandler().connect(key);
    }

    public void subscribe() {
        if (key == null) {
            throw new IllegalStateException("Cannot subscribe a unkey object");
        }

        ISubscribe subscribe = QUEUE.get(key);

        if (subscribe == null) {
            throw new IllegalStateException("Any subscribe has been set.");
        }

        subscribe.handle(callback);
    }
}