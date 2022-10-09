package com.example.fes.companyService.Model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRegisterRequest {

    private String companyCode;

    private String companyName;

    private String companyCeo;

    private double companyTurnover;

    private String companyWebsite;

    private String companyStockExchange;
}
