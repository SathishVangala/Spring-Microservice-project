package com.userService.UserService.payload;


import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@Data
@Builder
//@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    // Getters and setters
    private String  message;
    private boolean success;
    private HttpStatus status;

//    public ApiResponse(String message, boolean success, HttpStatus status) {
//        this.message = message;
//        this.success = success;
//        this.status = status;
//    }

}

