package com.spring.ai.nsfw.controller;

import com.spring.ai.nsfw.model.HttpModerateRequest;
import com.spring.ai.nsfw.service.ModerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController()
@RequestMapping("/api/v1/guardrail")
public class GuardrailController {

    @Autowired
    private ModerationService moderationService;

    @PostMapping("/content/safety")
    public ResponseEntity<String> moderate(@RequestBody HttpModerateRequest request) {

        String response = moderationService.detectNsfwText(request);
        log.info("Moderation - response: {}",response);
        return ResponseEntity.ok(response);
    }

}
