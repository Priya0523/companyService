package com.example.fes.companyService.Controller;

import com.example.fes.companyService.Model.CommonResponse;
import com.example.fes.companyService.Model.CompanyRegisterRequest;
import com.example.fes.companyService.Service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/market/company")
@CrossOrigin("*")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyService;

    @GetMapping("/getall")
    public ResponseEntity<CommonResponse> fetchAllCompanyDetails() throws Exception {
        CommonResponse response = companyService.fetchAllCompanyDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/registerCompany")
    public ResponseEntity<CommonResponse> registerCompany(@RequestBody CompanyRegisterRequest request) {
        CommonResponse response = companyService.registerCompany(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{companyCode}")
    public ResponseEntity<CommonResponse> deleteCompanyByCompanyCode(@PathVariable("companyCode") String companyCode) {
        CommonResponse response = companyService.deleteCompanyByCompanyCode(companyCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/info/{companyCode}")
    public ResponseEntity<CommonResponse> fetchCompanyDetailsByCompanyCode (@PathVariable("companyCode") String companyCode) {
        CommonResponse response = companyService.fetchCompanyDetailsByCode(companyCode);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
