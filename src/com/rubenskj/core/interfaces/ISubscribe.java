package com.rubenskj.core.interfaces;

public interface ISubscribe {

    void handle(ICallback iCallback);

    void register(String key);
}
