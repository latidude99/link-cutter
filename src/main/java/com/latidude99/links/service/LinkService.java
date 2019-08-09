package com.latidude99.links.service;

import com.latidude99.links.AppProperties;
import com.latidude99.links.repository.InMemoryMapLinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    @Autowired
    AppProperties appProperties;

    @Autowired
    InMemoryMapLinkRepo inMemoryMapLinkRepo;

    public String makeShortLink(String link){
        String shortLink = inMemoryMapLinkRepo.getShortLink(link);
        return appProperties.getUrlBase() + shortLink;
    }

    public String getOriginalLink(String shortLink){
        System.out.println("OriginalLink: " + inMemoryMapLinkRepo.getOriginalLink(shortLink));
        return inMemoryMapLinkRepo.getOriginalLink(shortLink);
    }
}
