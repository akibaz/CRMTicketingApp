package dev.akibaz.crm_ticketing.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String contactPerson;

    @Email
    private String email;

    private String phone;
}
