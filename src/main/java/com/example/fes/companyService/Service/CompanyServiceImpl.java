package com.example.fes.companyService.Service;

import com.example.fes.companyService.Entity.Company;
import com.example.fes.companyService.Model.CommonResponse;
import com.example.fes.companyService.Model.CompanyRegisterRequest;
import com.example.fes.companyService.Repository.CompanyRepository;
import com.example.fes.companyService.kafka.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository repository;

    @Autowired
    Producer producer;

    @Override
    public CommonResponse registerCompany(CompanyRegisterRequest request) {
        String message;
        String messageType;
        HttpStatus messageCode;

        Company companyDetails = new Company();

        try {
            companyDetails.setCompanyCode(request.getCompanyCode());
            companyDetails.setCompanyName(request.getCompanyName());
            companyDetails.setCompanyCeo(request.getCompanyCeo());
            companyDetails.setCompanyTurnover(request.getCompanyTurnover());
            companyDetails.setCompanyWebsite(request.getCompanyWebsite());
            companyDetails.setCompanyStockExchange(request.getCompanyStockExchange());
            //producer.sendMessage("New company has been registered successfully");
            repository.save(companyDetails);

            message = "Success";
            messageType = "success";
            messageCode = HttpStatus.CREATED;
        } catch (Exception ex) {
            message = "Internal Server Error";
            messageType = "Failure";
            messageCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return CommonResponse
                .builder()
                .message(message)
                .messageCode(messageCode)
                .messageType(messageType)
                .build();
    }

    @Override
    public CommonResponse fetchAllCompanyDetails() {

        String message;
        String messageType;
        HttpStatus messageCode;

        List<Company> companyList = new ArrayList<>();
        try {
            companyList = repository.findAll();

            message = "Success";
            messageType = "success";
            messageCode = HttpStatus.OK;
        } catch (Exception e) {
            message = "Internal Server Error";
            messageType = "Failure";
            messageCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return CommonResponse
                .builder()
                .message(message)
                .messageCode(messageCode)
                .companyList(companyList)
                .messageType(messageType)
                .build();
    }

    public CommonResponse deleteCompanyByCompanyCode(String companyCode) {

        String message;
        String messageType;
        HttpStatus messageCode;

        try {
            repository.deleteByCompanyCode(companyCode);
            message = "Success";
            messageType = "success";
            messageCode = HttpStatus.OK;
        } catch (Exception e) {
            message = "Internal Server Error";
            messageType = "Failure";
            messageCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return CommonResponse
                .builder()
                .message(message)
                .messageCode(messageCode)
                .messageType(messageType)
                .build();
    }

    @Override
    public CommonResponse fetchCompanyDetailsByCode(String companyCode) {

        String message;
        String messageType;
        HttpStatus messageCode;
        Company company = new Company();
        try{
           company = repository.fetchByCompanyCode(companyCode);
            message = "Success";
            messageType = "success";
            messageCode = HttpStatus.OK;
        }
        catch(Exception ex){
            log.error("Error occured while fetching company list");
            message = "Internal Server Error";
            messageType = "Failure";
            messageCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return CommonResponse
                .builder()
                .company(company)
                .messageCode(messageCode)
                .message(message)
                .messageType(messageType)
                .build();
    }
}

