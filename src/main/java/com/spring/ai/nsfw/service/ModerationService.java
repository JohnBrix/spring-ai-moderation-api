package com.spring.ai.nsfw.service;

import com.spring.ai.nsfw.model.HttpModerateRequest;

/**
 * package com.spring.ai.nsfw.service; /**
 *
 * @author <John Brix Pomoy>
 * @version $Id: ModerationService.java, v 0.1 2026-03-30 7:21 AM John Brix Pomoy Exp $$
 */
public interface ModerationService {
    String detectNsfwText (HttpModerateRequest request);
}
