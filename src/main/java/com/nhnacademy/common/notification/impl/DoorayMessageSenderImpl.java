package com.nhnacademy.common.notification.impl;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.common.notification.MessageSender;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DoorayMessageSenderImpl implements MessageSender {
    private final DoorayHookSender doorayHookSender;

    @Override
    public void send(String message) {
        DoorayHook hook = DoorayHook.builder()
                .botName(BOT_NAME)
                .text(message)
                .build();

        doorayHookSender.send(hook);
    }
}
