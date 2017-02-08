package com.renault.wired.services;


import com.renault.wired.domain.LeadFile;

public interface LeadFileService {
    Iterable<LeadFile> listAllLeadFiles();

    LeadFile getLeadFileById(Integer id);

    LeadFile saveLeadFile(LeadFile product);
}
