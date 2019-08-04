package com.latidude99.links.service;

import com.latidude99.links.dto.LinkDTOH2;
import com.latidude99.links.model.Link;
import com.latidude99.links.repository.H2LinkRepository;
import com.latidude99.links.util.LinkUtils;
import com.latidude99.links.util.RandomIdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class LinkServiceH2 {
    public static final String URL_BASE = "http://localhost:8080/";
    public static final long DEFAULT_EXPIRY_DAYS = 5L;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");

    @Autowired
    H2LinkRepository h2LinkRepository;

    @Autowired
    RandomIdentifierGenerator generator;

    public LinkDTOH2 createAndSaveShortLink(LinkDTOH2 formLink) {
        Link link = new Link();
        link.setLink(formLink.getOriginal());
        link.setCreated(LocalDateTime.now());
        link.setPin(generator.randomPin(6));
        link.setDeleted(false);
        if (formLink.getExpiryDays() == 0)
            link.setExpiryDays(DEFAULT_EXPIRY_DAYS);
        else
            link.setExpiryDays(formLink.getExpiryDays());
        h2LinkRepository.save(link);
        Optional<Link> linkOptional = h2LinkRepository.findByPin(link.getPin());
        String shortLink = linkOptional.get().getId().toString();
        LinkDTOH2 linkDTOH2 = new LinkDTOH2();
        linkDTOH2.setShortened(URL_BASE + shortLink);
        linkDTOH2.setPin(link.getPin());
        linkDTOH2.setExpiresIn(LinkUtils.timeToExpire(link));
        return linkDTOH2;
    }

    public LinkDTOH2 getOriginalLink(String id) {
        Optional<Link> linkOptional = h2LinkRepository.findById(Long.parseLong(id));
        Link link = linkOptional.get();
        LinkDTOH2 linkDTOH2 = convertLinkToLinkDTOH2(link);
        if(!link.isDeleted() && !link.isExpired())
            link.setVisited(link.getVisited() + 1);
        h2LinkRepository.save(link);
        return linkDTOH2;
    }

    public LinkDTOH2 deleteLink(LinkDTOH2 formLink) {
        String id = formLink.getShortened().substring(formLink.getShortened().lastIndexOf("/") + 1);
        Optional<Link> linkOptional = h2LinkRepository.findById(Long.parseLong(id));
        Link link = linkOptional.get();
        if (link.getPin().equals(formLink.getPin())) {
            link.setDeleted(true);
            link.setDeletedTime(LocalDateTime.now());
            h2LinkRepository.save(link);
        }
        LinkDTOH2 linkDTOH2 = convertLinkToLinkDTOH2(link);
        return linkDTOH2;
    }

    public LinkDTOH2 getOriginalLinkInfo(String id) {
        if (id != null && !"".equals(id)) {
            Optional<Link> linkOptional = h2LinkRepository.findById(Long.parseLong(id));
            Link link = linkOptional.get();
            LinkDTOH2 linkDTOH2 = convertLinkToLinkDTOH2(link);
            return linkDTOH2;
        } else {
            return new LinkDTOH2();
        }
    }

    private LinkDTOH2 convertLinkToLinkDTOH2(Link link) {
        LinkDTOH2 linkDTOH2 = new LinkDTOH2();
        linkDTOH2.setOriginal(link.getLink());
        linkDTOH2.setShortened(URL_BASE + link.getId());
        linkDTOH2.setCreated(link.getCreated());
        linkDTOH2.setVisited(link.getVisited());
        if (!link.isDeleted())
            linkDTOH2.setExpiresIn(LinkUtils.timeToExpire(link));
        else if (LinkUtils.timeSinceDeleted(link) > 1){
            linkDTOH2.setExpiresIn("deleted on "  + formatter.format(link.getDeletedTime()) +
                    " / " + LinkUtils.timeBetweenDeletedAndExpired(link));
        }else{
            linkDTOH2.setExpiresIn("deleted just a second ago" +
                    " / " + LinkUtils.timeBetweenDeletedAndExpired(link));
        }

        linkDTOH2.setExpired(LinkUtils.isLinkExpired(link));
        linkDTOH2.setDeleted(link.isDeleted());
        return linkDTOH2;
    }


}









