package org.bfsi.orchestration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeadResponse {

    private String statusCode;
    private String leadId;
    private String message;

}
