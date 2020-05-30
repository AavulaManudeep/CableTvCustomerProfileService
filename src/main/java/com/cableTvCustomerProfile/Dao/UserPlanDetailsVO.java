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
@Table(name = "userplandetails", catalog = "customer_profile")
public class UserPlanDetailsVO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="plan_id")
    private Integer planId;
    @Column(name="plannmae")
    private String planName;
    @Column(name = "price")
    private Float price;
    @OneToOne(fetch = FetchType.EAGER,mappedBy = "userPlanDetailsVO")
    private UserDetails userdetails;

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
