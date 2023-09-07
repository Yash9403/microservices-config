package com.lcwd.user.service.payload;

import lombok.*;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponce {

    private String msg;
    private boolean success;
    private HttpStatus status;
}
