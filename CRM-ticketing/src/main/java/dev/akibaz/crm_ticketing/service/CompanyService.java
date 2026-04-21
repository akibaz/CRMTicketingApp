package dev.akibaz.crm_ticketing.service;

import dev.akibaz.crm_ticketing.dto.CompanyRequest;
import dev.akibaz.crm_ticketing.dto.CompanyResponse;
import dev.akibaz.crm_ticketing.entity.Company;
import dev.akibaz.crm_ticketing.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyResponse create(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setContactPerson(companyRequest.getContactPerson());
        company.setEmail(companyRequest.getEmail());
        company.setPhone(companyRequest.getPhone());

        Company saved = companyRepository.save(company);
        return mapToResponse(saved);
    }

    public List<CompanyResponse> findAll() {
        return companyRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public CompanyResponse findById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
        return mapToResponse(company);
    }


    private CompanyResponse mapToResponse(Company company) {
        return new CompanyResponse(
                company.getId(),
                company.getName(),
                company.getContactPerson(),
                company.getEmail(),
                company.getPhone()
        );
    }
}
