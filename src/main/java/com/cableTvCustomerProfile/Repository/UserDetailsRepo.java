package com.cableTvCustomerProfile.Repository;

import com.cableTvCustomerProfile.Dao.UserAddress;
import com.cableTvCustomerProfile.Dao.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails,String> {

    @Query("SELECT add.userAddress FROM UserDetails add WHERE add.customerId = :customerId")
    public UserAddress findByUserAddress(@Param("customerId") String customerId);
}
