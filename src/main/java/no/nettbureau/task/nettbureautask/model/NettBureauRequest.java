package no.nettbureau.task.nettbureautask.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NettBureauRequest {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    private String email;
    @NotEmpty
    private String address;
    @NotBlank
    private String city;
    @NotBlank
    @Pattern(regexp = "\\d{4}", message = "Postal code should be 4 digits")
    private String postalCode;
    @NotBlank
    private String country;
    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "Phone number should be 8 digits")
    private String phoneNumber;

    @NotBlank
    private String password;

    private String dateOfBirth;
}
