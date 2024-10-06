package com.kapil.springbootbasicproject3_datasupply.beans;

import org.springframework.stereotype.Component;

@Component
public class PaytmPay implements PaymentPartners{

    @Override
    public void payment(String amount) {
        System.out.println("Payment by PaytmPay" + amount);
    }
}
