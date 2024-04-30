package com.nhnacademy.common.notification.impl;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.common.notification.MessageSender;
import org.springframework.web.client.RestTemplate;

public class DoorayMessageSenderImpl implements MessageSender {
    private static final String URL = "https://hook.dooray.com/services/3204376758577275363/3792943102224549864/3UgOwGIUSzmN7uKT1iQmzQ";
    private static final DoorayHookSender DOORAY_HOOK_SENDER= new DoorayHookSender(new RestTemplate(), URL);

    public void send(String message) {
        DoorayHook hook = DoorayHook.builder()
                .botName(BOT_NAME)
                .text(message)
                .build();

        DOORAY_HOOK_SENDER.send(hook);
    }
}
