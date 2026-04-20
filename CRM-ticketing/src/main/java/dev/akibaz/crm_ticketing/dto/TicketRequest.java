package dev.akibaz.crm_ticketing.dto;

import dev.akibaz.crm_ticketing.entity.TicketPriority;
import dev.akibaz.crm_ticketing.entity.TicketStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequest {

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private TicketStatus status;

    @NotNull
    private TicketPriority priority;

    @NotNull
    private Long companyId;
}
