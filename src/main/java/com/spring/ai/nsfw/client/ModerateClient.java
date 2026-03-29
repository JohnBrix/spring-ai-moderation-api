package com.spring.ai.nsfw.client;


public interface ModerateClient {
    String validateSafeText(String text);
}
