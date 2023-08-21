package org.bfsi.orchestration.bean;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationEntity {


    private String leadId;

    private String firstName;

    private String lastname;

    private String email;

    private String mobile;

    private String message;

    private String status;


}
