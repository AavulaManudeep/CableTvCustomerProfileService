package com.cableTvCustomerProfile.Controller;


import com.cableTvCustomerProfile.Dao.UserDetails;
import com.cableTvCustomerProfile.Service.UserDetailsService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins= "*",allowedHeaders = "*")
@RestController
@RequestMapping("/customerprofile")
@ControllerAdvice
public class Controller {
    //private static final Logger logger = LogManager.getLogger("Controller");
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping(value = "/userdetails",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.ALL_VALUE)
    public ResponseEntity<UserDetails> userinfo(@RequestBody String customerId)
    {
        logger.error("Insertion Started");
        logger.error("Insertion Test");

        customerId = customerId.replace("=","");
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
    @PostMapping("/insertuserdetails")
    public ResponseEntity<String> insertUserinfo( @RequestBody UserDetails userDetails)
    {
        try {
            if(userDetails==null)
                return new ResponseEntity<String>("userdetails is Empty",HttpStatus.BAD_REQUEST);
            userDetailsService.insertUserdetails(userDetails);
            return new ResponseEntity<String>("Success",HttpStatus.OK);
        }
        catch (Exception ex)
        {
            logger.error("Error occurred while inserting userdetails into DB :",ex.getMessage());
            return new ResponseEntity<String>("",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/updateuserdetails")
    public ResponseEntity<String> updateUserinfo(@RequestBody UserDetails userDetails)
    {
        try {
            if(userDetails==null)
                return new ResponseEntity<String>("userdetails is Empty",HttpStatus.BAD_REQUEST);
            userDetailsService.insertUserdetails(userDetails);
            return new ResponseEntity<String>("Success",HttpStatus.OK);
        }
        catch (Exception ex)
        {
            logger.error("Error occurred while updating userdetails into DB :",ex.getMessage());
            return new ResponseEntity<String>("",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping ("/retrievall")
    public ResponseEntity<List<UserDetails>> getAllCustomersInfo()
    {
        List<UserDetails> userDetailsList = userDetailsService.getAllCustomersInfo();

        return new ResponseEntity<List<UserDetails>>(userDetailsList,HttpStatus.OK);
    }


}
