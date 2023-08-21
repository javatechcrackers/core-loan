package org.bfsi.orchestration.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "bank_details")
@ToString
public class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String leadId;
    private String accountNumber;
    private String bankName;
    private String ifsc;

    private String branchName;
    private String pincode;
}
