package com.community.controller.rest;

import com.community.Exceptions.ApiException;
import com.community.data.EmailRepository;
import com.community.model.ApiErrorDetail;
import com.community.model.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value="/rest/emails", method= RequestMethod.POST)
    public EmailModel addEmail(@RequestBody String emailAddress){

        throw new ApiException("Method not implemented");
    }

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiErrorDetail myError(HttpServletRequest request, Exception exception) {
        ApiErrorDetail error = new ApiErrorDetail();
        error.setMessage(exception.getMessage());

        return error;
    }

}
