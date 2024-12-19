package com.quangbach1709.globits_rest_api.repository;

import com.quangbach1709.globits_rest_api.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
