package com.cableTvCustomerProfile.ServiceImpl;

import com.cableTvCustomerProfile.Dao.UserAddress;
import com.cableTvCustomerProfile.Dao.UserDetails;
import com.cableTvCustomerProfile.Dao.UserPlanDetailsVO;
import com.cableTvCustomerProfile.Repository.UserDetailsRepo;
import com.cableTvCustomerProfile.Service.UserDetailsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
public class UserDetailServiceImpl implements UserDetailsService {

    private static final Logger logger = LogManager.getLogger("UserDetailServiceImpl");

    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Override
    public UserDetails getUserdetails(String customerId) {
        Optional<UserDetails> userDetails = userDetailsRepo.findById(customerId);
        if(userDetails.isPresent())
        {
            return userDetails.get();
        }
        return null;
    }

    @Override
    public void insertUserdetails(UserDetails userdetails) throws Exception {
        try {
            if (userdetails != null) {
                userDetailsRepo.save(userdetails);
                logger.error("Inserting userdetails into the Database is been done successfully");
            }
        }
        catch(Exception ex)
        {
            logger.error("Error occurred while inserting userdetails into the Database ",ex.getStackTrace());
            throw new Exception("Exception occured");
        }
    }

    @Override
    public List<UserDetails> getAllCustomersInfo() {
        List<UserDetails> allUserDetails = userDetailsRepo.findAll();
        logger.error("allUserDetails :",allUserDetails);
        return allUserDetails;
    }

    @Override
    public UserAddress getUserAddress(String customerId)
    {
        try {
            UserAddress userAddress = userDetailsRepo.findByUserAddress(customerId);
            logger.error("userAddress :",userAddress);
            return userAddress;
        }
        catch(Exception ex) {
            logger.error("Error occurred while retrieving user address ", ex.getMessage() );
            return null;
        }
    }

    @Override
    public UserPlanDetailsVO getUserPlanDetails(String customerId) {
        return null;
    }
}
