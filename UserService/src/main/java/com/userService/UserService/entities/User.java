package com.userService.UserService.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Component
@Table(name = "users")
public class User {
    // getters + setters
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

   // @NotBlank(message = "Name is mandatory")
    private String name;

   // @NotBlank(message = "Email is mandatory")
   // @Email(message = "Invalid email")
    private String email;

   // @NotNull(message = "Date of birth is mandatory")
    private String dateOfBirth;

    @Transient
    List<Rating> ratings = new ArrayList<>();

}
