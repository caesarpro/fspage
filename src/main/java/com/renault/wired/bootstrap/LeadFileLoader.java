package com.renault.wired.bootstrap;

import com.renault.wired.repositories.LeadFileRepository;
import com.renault.wired.domain.LeadFile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Component
public class LeadFileLoader implements ApplicationListener<ContextRefreshedEvent> {

    private LeadFileRepository leadFileRepository;

    private Logger log = Logger.getLogger(LeadFileLoader.class);

    @Autowired
    public void setLeadFileRepository(LeadFileRepository leadFileRepository) {
        this.leadFileRepository = leadFileRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        LeadFile shirt = new LeadFile();


        shirt.setBody("text 1 ");
        shirt.setLeadFileId("235268845711068308");
        leadFileRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        LeadFile mug = new LeadFile();

        mug.setBody("text 2");
        mug.setLeadFileId("168639393495335947");
        leadFileRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }
}
