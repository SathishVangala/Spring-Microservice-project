package com.hotel.HotelService.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@Data
@Builder
//@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
