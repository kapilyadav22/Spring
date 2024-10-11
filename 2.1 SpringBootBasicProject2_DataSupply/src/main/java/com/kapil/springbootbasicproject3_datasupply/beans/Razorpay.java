package com.kapil.springbootbasicproject3_datasupply.beans;

import org.springframework.stereotype.Component;

@Component
public class Razorpay implements PaymentPartners{


    @Override
    public void payment(String amount) {
        System.out.println("Payment by Razorpay" + amount);
    }
}
