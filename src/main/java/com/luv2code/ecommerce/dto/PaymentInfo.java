package com.luv2code.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {

    private int amount;
    private String currency;
    private String receiptEmail;
}
