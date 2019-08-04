package com.latidude99.links.util;

import com.latidude99.links.model.Link;
import com.latidude99.links.repository.H2LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Component
public class LinkUtils {

    @Autowired
    H2LinkRepository h2LinkRepository;

    public List<Link> expiredLinksCleanup(List<Link> links){
        List<Link> deletedLinks;
        deletedLinks = links.stream()
                .filter(link -> !link.isDeleted())
                .filter(link -> isLinkExpired(link))
                .collect(Collectors.toList());
        deletedLinks.replaceAll(LinkUtils::setLinkExpired);
        deletedLinks.forEach(link -> h2LinkRepository.save(link));
        return deletedLinks;
    }


    public static boolean isLinkExpired(Link link) {
        LocalDateTime dateNow = LocalDateTime.now();
        LocalDateTime dateExpiry = link.getCreated().plusDays(link.getExpiryDays());
        if (dateExpiry.isBefore(dateNow))
            return true;
        else
            return false;
    }

    public static String timeToExpire(Link link) {
        String timeLeft;
        Duration duration = Duration.between(
                LocalDateTime.now(), link.getCreated().plusDays(link.getExpiryDays()));
        long mins = duration.toMinutes();
        if (mins > 0)
            timeLeft = minsToString(mins);
        else
            timeLeft = "expired";
        return timeLeft;
    }

    public static long timeSinceDeleted(Link link) {
        Duration duration = Duration.between(
                link.getDeletedTime(), LocalDateTime.now());
        long mins = duration.toMinutes();
        return mins;
    }

    public static String timeBetweenDeletedAndExpired(Link link) {
        String timeBetween;
        Duration duration = Duration.between(
                link.getDeletedTime(), link.getCreated().plusDays(link.getExpiryDays()));
        long mins = duration.toMinutes();
        if (mins >= 0)
            timeBetween = minsToString(mins) + " before expired";
        else
            timeBetween = minsToString(mins) + "after expired";
        return timeBetween;
    }

    private static Link setLinkExpired(Link link) {
        link.setExpired(true);
        return link;
    }

    private long minsToExpire(Link link) {
        Duration duration = Duration.between(
                LocalDateTime.now(), link.getCreated().plusDays(link.getExpiryDays()));
        return duration.toMinutes();
    }

    private String timeSinceDeletedFormatted(Link link) {
        String sinceDeleted = minsToString(timeSinceDeleted(link));
        return sinceDeleted;
    }

    private static String minsToString(long mins) {
        long minsPositive = mins < 0 ? mins = -1 * mins : mins;
        int days = (int) minsPositive / 1440;
        int hours = (int) ((minsPositive % 1440) / 60);
        int minutes = (int) ((minsPositive % 1440) % 60);
        String timeFormatted = "";
        if(days > 0)
            timeFormatted = days + " days, ";
        if(hours > 0)
            timeFormatted = timeFormatted + hours + " hours, ";
        timeFormatted = timeFormatted + minutes + " minutes";
        return timeFormatted;
    }

    public boolean isLinkDeleted(String id) {
        return h2LinkRepository.
                findById(Long.parseLong(id.trim()))
                .get()
                .isDeleted();
    }

    public boolean isLinkExpired(String id) {
        return h2LinkRepository.
                findById(Long.parseLong(id.trim()))
                .get()
                .isExpired();
    }
}
