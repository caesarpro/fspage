package com.renault.wired.services;

import com.renault.wired.domain.LeadFile;
import com.renault.wired.repositories.LeadFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadFileServiceImpl implements LeadFileService {
    private LeadFileRepository leadFileRepository;

    @Autowired
    public void setLeadFileRepository(LeadFileRepository leadFileRepository) {
        this.leadFileRepository = leadFileRepository;
    }

    @Override
    public Iterable<LeadFile> listAllLeadFiles() {
        return leadFileRepository.findAll();
    }

    @Override
    public LeadFile getLeadFileById(Integer id) {
        return leadFileRepository.findOne(id);
    }

    @Override
    public LeadFile saveLeadFile(LeadFile leadFile) {
        return leadFileRepository.save(leadFile);
    }
}
