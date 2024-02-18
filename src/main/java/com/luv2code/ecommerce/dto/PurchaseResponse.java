package com.luv2code.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class PurchaseResponse {

    @NonNull
    private String OrderTrackingNumber;
}
