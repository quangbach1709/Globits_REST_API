package com.quangbach1709.globits_rest_api.service;

import com.quangbach1709.globits_rest_api.DTO.CompanyDTO;
import com.quangbach1709.globits_rest_api.model.Company;
import com.quangbach1709.globits_rest_api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setName(companyDTO.getName());
        company.setCode(companyDTO.getCode());
        company.setAddress(companyDTO.getAddress());
        companyRepository.save(company);
        return companyDTO;
    }

    public CompanyDTO getCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        if (company == null) {
            return null;
        }
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        companyDTO.setCode(company.getCode());
        companyDTO.setAddress(company.getAddress());
        return companyDTO;
    }

    public List<CompanyDTO> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        for (Company company : companies) {
            CompanyDTO companyDTO = new CompanyDTO();
            companyDTO.setId(company.getId());
            companyDTO.setName(company.getName());
            companyDTO.setCode(company.getCode());
            companyDTO.setAddress(company.getAddress());
            companyDTOS.add(companyDTO);
        }
        return companyDTOS;
    }

    public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        if (company == null) {
            return null;
        }
        company.setName(companyDTO.getName());
        company.setCode(companyDTO.getCode());
        company.setAddress(companyDTO.getAddress());
        companyRepository.save(company);
        return companyDTO;
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
