package com.spring.ai.nsfw.client.impl;

import com.spring.ai.nsfw.client.ModerateClient;
import org.springframework.ai.moderation.*;
import org.springframework.ai.openai.OpenAiModerationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * package com.spring.ai.filipino.chatbot.service; /**
 *
 * @author <John Brix Pomoy>
 * @version $Id: TextModerationService.java, v 0.1 2026-03-23 10:52 AM John Brix Pomoy Exp $$
 */
@Component
public class ModerationClientImpl implements ModerateClient {

    @Autowired
    private OpenAiModerationModel openAiModerationModel;


    @Override
    public String validateSafeText(String text) {
        ModerationPrompt moderationRequest = new ModerationPrompt(text);
        ModerationResponse response = openAiModerationModel.call(moderationRequest);
        Moderation output = response.getResult().getOutput();

        return output.getResults().stream()
                .map(this::buildModerationResult)
                .collect(Collectors.joining("\n"));
    }

    private String buildModerationResult(ModerationResult moderationResult) {

        Categories categories = moderationResult.getCategories();

        String violations = Stream.of(
                        Map.entry("Sexual", categories.isSexual()),
                        Map.entry("Hate", categories.isHate()),
                        Map.entry("Harassment", categories.isHarassment()),
                        Map.entry("Self-Harm", categories.isSelfHarm()),
                        Map.entry("Sexual/Minors", categories.isSexualMinors()),
                        Map.entry("Hate/Threatening", categories.isHateThreatening()),
                        Map.entry("Violence/Graphic", categories.isViolenceGraphic()),
                        Map.entry("Self-Harm/Intent", categories.isSelfHarmIntent()),
                        Map.entry("Self-Harm/Instructions", categories.isSelfHarmInstructions()),
                        Map.entry("Harassment/Threatening", categories.isHarassmentThreatening()),
                        Map.entry("Violence", categories.isViolence()))
                .filter(entry -> Boolean.TRUE.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));

        return violations.isEmpty()
                ? "No category violations detected."
                : "Violated categories: " + violations;
    }
}