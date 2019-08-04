package com.latidude99.links;

import com.latidude99.links.model.Link;
import com.latidude99.links.repository.H2LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

@Component
public class InitDataLoad implements ApplicationRunner {

    @Autowired
    H2LinkRepository h2LinkRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Link testLink = new Link();
        testLink.setLink("latidude99.com");
        testLink.setVisited(99L);
        testLink.setPin("99");
        testLink.setCreated(LocalDateTime.of
                (2019, 07, 31, 14, 40));
        testLink.setExpiryDays(1L);
        testLink.setDeleted(false);
        h2LinkRepository.save(testLink);

        Link testLink1 = new Link();
        testLink1.setLink("1-latidude99.com");
        testLink1.setVisited(99L);
        testLink1.setPin("99");
        testLink1.setCreated(LocalDateTime.now().plusMinutes(1L));
        testLink1.setExpiryDays(0);
        testLink1.setDeleted(false);
        h2LinkRepository.save(testLink1);

        Link testLink2 = new Link();
        testLink2.setLink("2-latidude99.com");
        testLink2.setVisited(99L);
        testLink2.setPin("99");
        testLink2.setCreated(LocalDateTime.now().plusMinutes(1L));
        testLink2.setExpiryDays(0);
        testLink2.setDeleted(false);
        h2LinkRepository.save(testLink2);


        Link testLink3 = new Link();
        testLink3.setLink("3-latidude99.com");
        testLink3.setVisited(99L);
        testLink3.setPin("99");
        testLink3.setCreated(LocalDateTime.now().plusMinutes(1L));
        testLink3.setExpiryDays(0);
        testLink3.setDeleted(false);
        h2LinkRepository.save(testLink3);


        Link testLink4 = new Link();
        testLink4.setLink("4-latidude99.com");
        testLink4.setVisited(99L);
        testLink4.setPin("99");
        testLink4.setCreated(LocalDateTime.now().plusMinutes(2L));
        testLink4.setExpiryDays(0);
        testLink4.setDeleted(false);
        h2LinkRepository.save(testLink4);


        Link testLink5 = new Link();
        testLink5.setLink("5-latidude99.com");
        testLink5.setVisited(99L);
        testLink5.setPin("99");
        testLink5.setCreated(LocalDateTime.now().plusMinutes(3L));
        testLink5.setExpiryDays(0);
        testLink5.setDeleted(false);
        h2LinkRepository.save(testLink5);

        Link testLink6 = new Link();
        testLink6.setLink("6-latidude99.com");
        testLink6.setVisited(99L);
        testLink6.setPin("99");
        testLink6.setCreated(LocalDateTime.now().plusMinutes(5L));
        testLink6.setExpiryDays(0);
        testLink6.setDeleted(false);
        h2LinkRepository.save(testLink6);

        Link testLink7 = new Link();
        testLink7.setLink("7-latidude99.com");
        testLink7.setVisited(99L);
        testLink7.setPin("99");
        testLink7.setCreated(LocalDateTime.now().plusMinutes(10L));
        testLink7.setExpiryDays(0);
        testLink7.setDeleted(false);
        h2LinkRepository.save(testLink7);

        Link testLink8 = new Link();
        testLink8.setLink("8-latidude99.com");
        testLink8.setVisited(99L);
        testLink8.setPin("99");
        testLink8.setCreated(LocalDateTime.now().plusMinutes(20L));
        testLink8.setExpiryDays(0);
        testLink8.setDeleted(false);
        h2LinkRepository.save(testLink8);

        Link testLink9 = new Link();
        testLink9.setLink("9-latidude99.com");
        testLink9.setVisited(99L);
        testLink9.setPin("99");
        testLink9.setCreated(LocalDateTime.now().plusMinutes(30L));
        testLink9.setExpiryDays(0);
        testLink9.setDeleted(false);
        h2LinkRepository.save(testLink9);

        Link testLink10 = new Link();
        testLink10.setLink("10-latidude99.com");
        testLink10.setVisited(99L);
        testLink10.setPin("99");
        testLink10.setCreated(LocalDateTime.now().plusMinutes(40L));
        testLink10.setExpiryDays(0);
        testLink10.setDeleted(false);
        h2LinkRepository.save(testLink10);

        Link testLink11 = new Link();
        testLink11.setLink("11-latidude99.com");
        testLink11.setVisited(99L);
        testLink11.setPin("99");
        testLink11.setCreated(LocalDateTime.now().plusMinutes(50L));
        testLink11.setExpiryDays(0);
        testLink11.setDeleted(false);
        h2LinkRepository.save(testLink11);

        Link testLink12 = new Link();
        testLink12.setLink("12-latidude99.com");
        testLink12.setVisited(99L);
        testLink12.setPin("99");
        testLink12.setCreated(LocalDateTime.now().plusMinutes(60L));
        testLink12.setExpiryDays(0);
        testLink12.setDeleted(false);
        h2LinkRepository.save(testLink12);



    }

}