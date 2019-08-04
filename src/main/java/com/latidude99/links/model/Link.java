package com.latidude99.links.model;

import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String link;
    private String pin;
    private LocalDateTime created;
    private LocalDateTime deletedTime;
    private long visited;
    private long expiryDays;
    private boolean deleted;
    private boolean expired;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(LocalDateTime deletedTime) {
        this.deletedTime = deletedTime;
    }

    public long getVisited() {
        return visited;
    }

    public void setVisited(long visited) {
        this.visited = visited;
    }

    public long getExpiryDays() {
        return expiryDays;
    }

    public void setExpiryDays(long expiryDays) {
        this.expiryDays = expiryDays;
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

    @Override
    public String toString() {
        return "LinkConstraint{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", pin='" + pin + '\'' +
                ", created=" + created +
                ", visited=" + visited +
                ", expiryDays=" + expiryDays +
                ", deleted=" + deleted +
                ", expired=" + expired +
                '}';
    }
}
