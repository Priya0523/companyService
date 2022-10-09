package com.example.fes.companyService.Service;

import com.example.fes.companyService.Model.CommonResponse;
import com.example.fes.companyService.Model.CompanyRegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    CommonResponse fetchAllCompanyDetails();

    CommonResponse registerCompany(CompanyRegisterRequest request);

    CommonResponse deleteCompanyByCompanyCode(String companyCode);

    CommonResponse fetchCompanyDetailsByCode(String companyCode);

    }
