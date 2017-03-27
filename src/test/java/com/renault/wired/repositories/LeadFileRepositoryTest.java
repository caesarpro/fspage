package com.renault.wired.repositories;

import com.renault.wired.configuration.RepositoryConfiguration;
import com.renault.wired.domain.LeadFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class LeadFileRepositoryTest {

    private LeadFileRepository leadFileRepository;

    @Autowired
    public void setLeadFileRepository(LeadFileRepository leadFileRepository) {
        this.leadFileRepository = leadFileRepository;
    }

    @Test
    public void testSaveProduct() {
        //setup leadFile
        LeadFile leadFile = new LeadFile();

        leadFile.setBody("Text Json 1");
        leadFile.setLeadFileId("1234");

        //save leadFile, verify has ID value after save
        assertNull(leadFile.getId()); //null before save
        leadFileRepository.save(leadFile);
        assertNotNull(leadFile.getId()); //not null after save
        //fetch from DB
        LeadFile fetchedLeadFile = leadFileRepository.findOne(leadFile.getId());

        //should not be null
        assertNotNull(fetchedLeadFile);

        //should equal
        assertEquals(leadFile.getId(), fetchedLeadFile.getId());
        assertEquals(leadFile.getBody(), fetchedLeadFile.getBody());

        //update body and save
        leadFile.setBody(leadFile.getBody() + " modifié ");
        leadFileRepository.save(fetchedLeadFile);

        //get from DB, should be updated
        LeadFile fetchedUpdatedLeadFile = leadFileRepository.findOne(fetchedLeadFile.getId());
        assertEquals(fetchedLeadFile.getBody(), fetchedUpdatedLeadFile.getBody());

        //verify count of products in DB
        long productCount = leadFileRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<LeadFile> products = leadFileRepository.findAll();

        int count = 0;

        for (LeadFile p : products) {
            count++;
        }

        assertEquals(count, 1);
    }
}
