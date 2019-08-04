package com.latidude99.links;

import com.latidude99.links.model.Link;
import com.latidude99.links.repository.H2LinkRepository;
import com.latidude99.links.util.LinkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.logging.Logger;

@Configuration
@EnableScheduling
public class AppConfig {
    Logger logger = Logger.getLogger(AppConfig.class.getName());

    @Autowired
    H2LinkRepository h2LinkRepository;

    @Autowired
    LinkUtils linkUtils;

//    @Scheduled(cron ="${cron.expression}")
//    public void schedueTestTask(){
//        System.out.println("Scheduled, Fixed delay task: " + System.currentTimeMillis() / 1000);
//    }

    @Scheduled(cron ="${cron.expression}")
    public void deleteExpiredLinks(){
        List<Link> linksToCheck= h2LinkRepository.getAllByDeleted(false);
        List<Link> deletedLinks = linkUtils.expiredLinksCleanup(linksToCheck);
        deletedLinks.forEach(link -> logger.info("deleted expired link: " + link.getLink()));
    }


}
/* cron
<second> <minute> <hour> <day-of-month> <month> <day-of-week> <year> <command>


 */