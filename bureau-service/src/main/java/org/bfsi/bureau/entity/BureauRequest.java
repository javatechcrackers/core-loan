package org.bfsi.bureau.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bureau_request")
public class BureauRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bureauId;

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
