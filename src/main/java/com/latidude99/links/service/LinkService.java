package com.latidude99.links.service;

import com.latidude99.links.repository.InMemoryMapLinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    public static final String URL_BASE = "http://localhost:8080/";

    @Autowired
    InMemoryMapLinkRepo inMemoryMapLinkRepo;

    public String makeShortLink(String link){
        String shortLink = inMemoryMapLinkRepo.getShortLink(link);
        return URL_BASE + shortLink;
    }

    public String getOriginalLink(String shortLink){
        System.out.println("OriginalLink: " + inMemoryMapLinkRepo.getOriginalLink(shortLink));
        return inMemoryMapLinkRepo.getOriginalLink(shortLink);
    }
}
