package com.robertoele.FlashLyrics.entities;

public class TranslationRequest {
    private String source;
    private String target;
    private String q;
    private String format;

    public TranslationRequest(String source, String target, String text) {
        this.source = source;
        this.target = target;
        q = text;
        format = "text";
    }
    
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getTarget() { return target; }
    public void setTarget(String target) { this.target = target; }

    public String getQ() { return q; }
    public void setQ(String q) { this.q = q; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }
}
