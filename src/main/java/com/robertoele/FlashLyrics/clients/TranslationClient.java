package com.robertoele.FlashLyrics.clients;

import com.robertoele.FlashLyrics.entities.Translation;
import com.robertoele.FlashLyrics.entities.TranslationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class TranslationClient {
    private final RestTemplate template = new RestTemplate();

    public Translation getTranslation(String sourceLan, String targetLan, String text) {
        TranslationRequest sentObject = new TranslationRequest(sourceLan, targetLan, text);
        return template.postForObject("http://traduccion:5000/translate", sentObject, Translation.class);
    }
}
