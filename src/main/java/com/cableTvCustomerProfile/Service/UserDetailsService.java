package com.cableTvCustomerProfile.Service;


import com.cableTvCustomerProfile.Dao.UserAddress;
import com.cableTvCustomerProfile.Dao.UserDetails;
import com.cableTvCustomerProfile.Dao.UserPlanDetailsVO;

import java.util.List;

public interface UserDetailsService {

    public UserDetails getUserdetails(String customerId);

    public void insertUserdetails(UserDetails userdetails) throws Exception;

    public List<UserDetails> getAllCustomersInfo();

    public UserAddress getUserAddress(String customerId);

    public UserPlanDetailsVO getUserPlanDetails(String customerId);

}
