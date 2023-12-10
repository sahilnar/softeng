package com.example.exam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaveSaleRequest {

    private int id;
    private String salesmanname;
    private String item;
    private double amount;
    private LocalDate transactionDate;
}
