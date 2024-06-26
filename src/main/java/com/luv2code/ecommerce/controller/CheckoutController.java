package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.dto.PaymentInfo;
import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.luv2code.ecommerce.service.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    private static final Logger log = LoggerFactory.getLogger(CheckoutController.class);


    @PostMapping("/purchase")
    private ResponseEntity<PurchaseResponse> placeOrder(@RequestBody Purchase purchase){
        log.info("REST request to Place Order , {}", purchase);
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return ResponseEntity.status(HttpStatus.OK).body(purchaseResponse);
    }


    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException {
        log.info("REST request to payment via stripe, {}",paymentInfo);
        log.info("paymentInfo.amount: " + paymentInfo.getAmount());

        PaymentIntent paymentIntent = checkoutService.createPaymentIntent(paymentInfo);

        String paymentStr = paymentIntent.toJson();

        return ResponseEntity.status(HttpStatus.OK).body(paymentStr);
    }
}
