package com.spring.ai.nsfw.service.impl;

import com.spring.ai.nsfw.client.ModerateClient;
import com.spring.ai.nsfw.model.HttpModerateRequest;
import com.spring.ai.nsfw.service.ModerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModerationServiceImpl implements ModerationService {

    @Autowired
    private ModerateClient moderateClient;

    @Override
    public String detectNsfwText(HttpModerateRequest request) {

        return moderateClient.validateSafeText(request.getText());
    }
}
