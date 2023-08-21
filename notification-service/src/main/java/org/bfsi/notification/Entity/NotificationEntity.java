package org.bfsi.notification.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notification")
public class NotificationEntity {

    @Id
    private String id;

    private String leadId;

    private String firstName;

    private String lastname;

    private String email;

    private String mobile;

    private String message;

    private String status;


}
