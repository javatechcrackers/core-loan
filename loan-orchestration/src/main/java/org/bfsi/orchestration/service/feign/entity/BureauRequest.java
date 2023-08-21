package org.bfsi.orchestration.service.feign.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BureauRequest {

    private String leadId;
    private String firstName;
    private String lastName;
    private String pan;
    private String mobileNumber;
    private String email;
    private String amount;
    private String city;
    private String address1;
    private String address2;
    private String pincode;

}