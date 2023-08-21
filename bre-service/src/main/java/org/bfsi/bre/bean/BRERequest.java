package org.bfsi.bre.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bre_request")
public class BRERequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breId;

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
