package com.renault.wired.controllers;

import com.renault.wired.domain.LeadFile;
import com.renault.wired.services.LeadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LeadFileController {

    private LeadFileService leadFileService;

    @Autowired
    public void setLeadFileService(LeadFileService leadFileService) {
        this.leadFileService = leadFileService;
    }

    @RequestMapping(value = "/leadFiles", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("leadFiles", leadFileService.listAllLeadFiles());
        System.out.println("Returning leadFiles:");
        return "leadFiles";
    }

    @RequestMapping("leadFile/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("leadFile", leadFileService.getLeadFileById(id));
        return "leadFileshow";
    }

    @RequestMapping("leadFile/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("leadFile", leadFileService.getLeadFileById(id));
        return "leadFileform";
    }

    @RequestMapping("leadFile/new")
    public String newProduct(Model model){
        model.addAttribute("leadFile", new LeadFile());
        return "leadFileform";
    }

    @RequestMapping(value = "leadFile", method = RequestMethod.POST)
    public String saveProduct(LeadFile leadFile){

        leadFileService.saveLeadFile(leadFile);

        return "redirect:/leadFile/" + leadFile.getId();
    }

}
