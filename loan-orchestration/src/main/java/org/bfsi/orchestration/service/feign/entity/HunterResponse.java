package org.bfsi.orchestration.service.feign.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "hunter_details")
public class HunterResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String leadId;
    private boolean isFraud;
    private String status;
    private String msg;

}
