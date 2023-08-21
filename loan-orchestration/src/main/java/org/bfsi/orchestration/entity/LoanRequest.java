package org.bfsi.orchestration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanRequest {

    private String leadId;
    private String firstName;
    private String lastName;
    private String pan;
    private String mobileNumber;
    private String email;

}
