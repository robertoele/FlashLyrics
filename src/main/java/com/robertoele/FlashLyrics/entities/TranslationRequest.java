package com.robertoele.FlashLyrics.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranslationRequest {
    private final @JsonProperty("source") String sourceLan;
    private final @JsonProperty("target") String targetLan;
    private final @JsonProperty("q") String text;
    private final @JsonProperty("format") String format;

    public TranslationRequest(String sourceLan, String targetLan, String text) {
        this.sourceLan = sourceLan;
        this.targetLan = targetLan;
        this.text = text;
        format = "text";
    }
}
