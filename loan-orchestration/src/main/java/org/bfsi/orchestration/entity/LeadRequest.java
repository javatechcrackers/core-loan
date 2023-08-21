package org.bfsi.orchestration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LeadRequest {

    private String leadId;
    PersonalDetails personalDetails;

    BankDetails bankDetails;

    Address homeAddress;

    Address officeAddress;

    ContactDetails contactDetails;

}
