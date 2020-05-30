package com.cableTvCustomerProfile.Dao;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@Table(name="useraddress",catalog = "customer_profile")
public class UserAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String address1;
    @Column
    private String address2;
    @Column
    private String aptno;
    @Column
    private String zipcode;
    @Column
    private String mandal;
    @Column
    private String district;
    @OneToOne(fetch = FetchType.EAGER,mappedBy = "userAddress")
    private UserDetails userDetails;

//    @Transient
//    private Map<String,Object> Otherproperties = new HashMap<>();
//
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
}
