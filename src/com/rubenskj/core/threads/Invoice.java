package com.rubenskj.core.threads;

import com.rubenskj.core.entity.Subscribe;

import java.util.logging.Logger;

public class Invoice {

    private static final Logger LOGGER = Logger.getLogger(Invoice.class.getName());

    private Subscribe subscribe;

    public void produce() throws InterruptedException {
        LOGGER.info("Creating subscribe..");
        subscribe = new Subscribe(this::handleCallback);

        LOGGER.info("Waiting..");
        Thread.sleep(1000);

        LOGGER.info("Consuming..");
        subscribe.subscribe();
    }

    private void handleCallback() {
        LOGGER.info("Handling callback");
    }
}
