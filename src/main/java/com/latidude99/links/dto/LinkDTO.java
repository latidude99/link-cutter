package com.latidude99.links.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LinkDTO {
    private String original;
    private String shortened;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getShortened() {
        return shortened;
    }

    public void setShortened(String shortened) {
        this.shortened = shortened;
    }
}
