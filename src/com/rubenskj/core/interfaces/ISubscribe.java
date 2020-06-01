package com.rubenskj.core.interfaces;

public interface ISubscribe {

    void handle(ICallback iCallback);

    void connect(String key);
}
