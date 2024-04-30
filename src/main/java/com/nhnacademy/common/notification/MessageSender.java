package com.nhnacademy.common.notification;

public interface MessageSender {
    String BOT_NAME = "notification";

    void send(String message);
}
