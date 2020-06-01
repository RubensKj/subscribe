package com.rubenskj.core.entity;

import com.rubenskj.core.interfaces.ICallback;
import com.rubenskj.core.interfaces.ISubscribe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class SubscribeHandler implements ISubscribe {

    private static final Logger LOGGER = Logger.getLogger(SubscribeHandler.class.getName());
    public static final Map<String, ISubscribe> queue = new ConcurrentHashMap<>();

    private String key;

    public SubscribeHandler() {
    }

    public SubscribeHandler(String key) {
        this.key = key;
    }

    @Override
    public void handle(ICallback callback) {
        if (callback == null) {
            return;
        }

        callback.run();
        queue.remove(this.getKey());
    }

    @Override
    public void register(String key) {
        SubscribeHandler subscribeHandler = new SubscribeHandler(key);

        LOGGER.info("Registering subscribe with key -> " + key + "; subscriber -> {" + subscribeHandler + "}");
        queue.put(key, subscribeHandler);
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "SubscribeHandler{" +
                "key='" + key + '\'' +
                '}';
    }
}
