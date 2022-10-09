package com.example.fes.companyService.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    private int companyId;

    @Column(name="company_code", nullable = false)
    private String companyCode;

    @Column(name="company_name", nullable = false)
    private String companyName;

    @Column(name="company_ceo", nullable = false)
    private String companyCeo;

    @Column(name="company_turnover", nullable = false)
    private double companyTurnover;

    @Column(name="company_website", nullable = false)
    private String companyWebsite;

    @Column(name="companyStockExchange", nullable = false)
    private String companyStockExchange;
}
