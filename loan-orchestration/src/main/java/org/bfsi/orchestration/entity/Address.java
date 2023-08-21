package org.bfsi.orchestration.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "address_details")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String leadId;

    private String address1;
    private String address2;

    private String city;

    private String pincode;

    private String state;

    private String typeOfAddress;
}
