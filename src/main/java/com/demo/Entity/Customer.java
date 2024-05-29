package com.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Validated_Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name must not be blank")
    @Size(min = 5, message = "First name must be less than 50 characters")
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    @Size(min =   5, message = "Last name must be less than 50 characters")
    private String lastName;

    @NotBlank(message = "Email must not be blank")
    
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number must not be blank")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    private String phoneNumber;

    @NotNull(message = "Age must not be null")
    @Positive(message="Age must be Positive")
    private Integer age;
}