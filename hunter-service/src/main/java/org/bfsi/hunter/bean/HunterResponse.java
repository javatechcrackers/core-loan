package org.bfsi.hunter.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HunterResponse {

    private String leadId;
    private boolean isFraud;
    private String status;
    private String msg;

}
