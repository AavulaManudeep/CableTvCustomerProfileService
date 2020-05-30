package com.cableTvCustomerProfile.Dao;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Data
@Entity
@Table(name = "userdetails", catalog = "customer_profile")
public class UserDetails implements Serializable {

    @Id
    @Column(name = "customer_id")
    private  String customerId;
    @Column(name = "first_Name")
    private  String firstName;
    @Column(name = "last_Name")
    private String lastName;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "useraddress")
    private UserAddress userAddress;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "plandetails")
    private UserPlanDetailsVO userPlanDetailsVO;

//    @Transient
//    private Map<String,Object> Otherproperties = new HashMap<>();

//    @JsonAnyGetter
//    private Map<String,Object> getOtherproperties()
//    {
//        return this.Otherproperties;
//    }
//    @JsonAnySetter
//    private void setOtherproperties(String key,Object obj)
//    {
//        Otherproperties.put(key,obj);
//    }
//    public UserDetails()
//    {
//        this.userAddress.setUserDetails(this);
//        this.userPlanDetailsVO.setUserdetails(this);
//    }

}
