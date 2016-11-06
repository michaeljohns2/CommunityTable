package com.community.controller.rest;

import com.community.data.EmailRepository;
import com.community.model.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This implements a REST API to manage email data.
 */
// This annotation tells the controller to return JSON.
@RestController
public class EmailRestController {

    @Autowired
    private EmailRepository emailRepo;

    @RequestMapping(value="/rest/emails", method= RequestMethod.GET)
    public List<EmailModel> getEmails() {
        return emailRepo.getAllEmails();
    }


}
