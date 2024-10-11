package com.kapil.springbootbasicproject3_datasupply.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Flipkart {

    @Autowired
    @Qualifier("paytmPay")
    PaymentPartners paymentPartners;

    public void PaymentGateway(){
        paymentPartners.payment("  Rs 200");
    }
}
