package com.robertoele.FlashLyrics.services;

import com.robertoele.FlashLyrics.clients.TranslationClient;
import com.robertoele.FlashLyrics.entities.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {
    @Autowired private TranslationClient client;

    public Translation translate(String source, String target, String text) {
        return client.getTranslation(source, target, text);
    }

    public Translation translate(String target, String text) {
        return client.getTranslation("auto", target, text);
    }
}
