package dev.akibaz.crm_ticketing.dto;

import dev.akibaz.crm_ticketing.entity.TicketPriority;
import dev.akibaz.crm_ticketing.entity.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketResponse {

    private Long id;
    private String title;
    private String description;
    private TicketStatus status;
    private TicketPriority priority;
    private Long companyId;
    private String companyName;

}
