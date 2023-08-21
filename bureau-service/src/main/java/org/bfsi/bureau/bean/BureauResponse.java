package org.bfsi.bureau.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BureauResponse {

    private String leadId;
    private String score;
    private String status;
    private String msg;

}
