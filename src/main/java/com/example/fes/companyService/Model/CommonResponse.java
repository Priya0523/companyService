package com.example.fes.companyService.Model;


import com.example.fes.companyService.Entity.Company;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse {

    String message = "";
    String messageType = "";
    HttpStatus messageCode;
    List<Company> companyList;
    Company company;
}
