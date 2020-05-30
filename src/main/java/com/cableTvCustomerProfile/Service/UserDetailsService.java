package com.cableTvCustomerProfile.Service;


import com.cableTvCustomerProfile.Dao.UserAddress;
import com.cableTvCustomerProfile.Dao.UserDetails;
import com.cableTvCustomerProfile.Dao.UserPlanDetailsVO;

public interface UserDetailsService {

    public UserDetails getUserdetails(String customerId);

    public void insertUserdetails(UserDetails userdetails) throws Exception;

    public UserAddress getUserAddress(String customerId);

    public UserPlanDetailsVO getUserPlanDetails(String customerId);

}
