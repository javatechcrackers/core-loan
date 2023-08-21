package org.bfsi.orchestration.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Builder
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseBean {
    private String errorCode;
    private String message;

}
