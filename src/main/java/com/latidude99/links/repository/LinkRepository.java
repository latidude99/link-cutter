package com.latidude99.links.repository;

import org.springframework.stereotype.Component;

@Component
public interface LinkRepository {

    String getShortLink(String longAddress);
    String getOriginalLink(String shortAddress);
}
