package com.latidude99.links.dto;

import com.latidude99.links.util.LinkConstraint;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDateTime;

@Component
@RequestScope
public class LinkDTOH2 {
    @LinkConstraint //(message = "This is not a valid URL address. Needs to start with: http://, https:// or ftp://")
    private String original;
    private String shortened;
    private LocalDateTime created;
    private long expiryDays = 5L; // default value for the user form
    private long expiresInDays;
    private String expiresIn;
    private long visited;
    private boolean deleted;
    private boolean expired;
    private String pin;


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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public long getExpiryDays() {
        return expiryDays;
    }

    public void setExpiryDays(long expiryDays) {
        this.expiryDays = expiryDays;
    }

    public long getExpiresInDays() {
        return expiresInDays;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setExpiresInDays(long expiresInDays) {
        this.expiresInDays = expiresInDays;
    }

    public long getVisited() {
        return visited;
    }

    public void setVisited(long visited) {
        this.visited = visited;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String   toString() {
        return "LinkDTOH2{" +
                "original='" + original + '\'' +
                ", shortened='" + shortened + '\'' +
                ", created=" + created +
                ", expiryDays=" + expiryDays +
                ", expiresInDays=" + expiresInDays +
                ", expiresIn='" + expiresIn + '\'' +
                ", visited=" + visited +
                ", deleted=" + deleted +
                ", expired=" + expired +
                '}';
    }
}
