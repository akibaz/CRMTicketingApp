package dev.akibaz.crm_ticketing.service;

import dev.akibaz.crm_ticketing.dto.TicketRequest;
import dev.akibaz.crm_ticketing.dto.TicketResponse;
import dev.akibaz.crm_ticketing.entity.Company;
import dev.akibaz.crm_ticketing.entity.Ticket;
import dev.akibaz.crm_ticketing.repository.CompanyRepository;
import dev.akibaz.crm_ticketing.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final CompanyRepository companyRepository;

    public TicketResponse create(TicketRequest request) {
        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + request.getCompanyId()));

        Ticket ticket = new Ticket();
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setStatus(request.getStatus());
        ticket.setPriority(request.getPriority());
        ticket.setCompany(company);
        
        Ticket saved = ticketRepository.save(ticket);
        return mapToResponse(saved);
    }

    public List<TicketResponse> findAll() {
        return ticketRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public TicketResponse findById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
        return mapToResponse(ticket);
    }

    private TicketResponse mapToResponse(Ticket ticket) {
        return new TicketResponse(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getStatus(),
                ticket.getPriority(),
                ticket.getCompany().getId(),
                ticket.getCompany().getName()
        );
    }

}
