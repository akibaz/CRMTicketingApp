package dev.akibaz.crm_ticketing.repository;

import dev.akibaz.crm_ticketing.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
