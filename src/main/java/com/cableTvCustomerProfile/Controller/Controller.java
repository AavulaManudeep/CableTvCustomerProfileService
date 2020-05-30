package com.cableTvCustomerProfile.Controller;


import com.cableTvCustomerProfile.Dao.UserDetails;
import com.cableTvCustomerProfile.Service.UserDetailsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin(origins= "*",allowedHeaders = "*")
@RestController
@RequestMapping("/customerprofile")
@ControllerAdvice
public class Controller {
    private static final Logger logger = LogManager.getLogger("Controller");

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping(value = "/userdetails",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetails> userinfo(@RequestBody String customerId)
    {
        UserDetails userDetails = null;
        try {
            userDetails = userDetailsService.getUserdetails(customerId);
            return new ResponseEntity<UserDetails>(userDetails,HttpStatus.OK);
        }
        catch (Exception ex)
        {
            userDetails = new UserDetails();
            return new ResponseEntity<UserDetails>(userDetails,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/insetuserdetails")
    public ResponseEntity<String> insertUserinfo( @RequestBody UserDetails userDetails)
    {
        try {
            if(userDetails==null)
                return new ResponseEntity<String>("userdetails is Empty",HttpStatus.BAD_REQUEST);
            userDetailsService.insertUserdetails(userDetails);
            return new ResponseEntity<String>("",HttpStatus.OK);
        }
        catch (Exception ex)
        {
            logger.error("Error occurred while inserting userdetails into DB :",ex.getMessage());
            return new ResponseEntity<String>("",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
