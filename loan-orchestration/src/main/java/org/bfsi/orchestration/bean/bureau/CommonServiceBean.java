package org.bfsi.orchestration.bean.bureau;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommonServiceBean {
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
