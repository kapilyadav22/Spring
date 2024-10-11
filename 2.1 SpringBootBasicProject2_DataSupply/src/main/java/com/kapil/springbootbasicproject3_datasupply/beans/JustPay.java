package com.kapil.springbootbasicproject3_datasupply.beans;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//either use qualifier or primary,
//using both is not good practice, still if we use both, then qualifier will get more priority
@Component
@Primary
public class JustPay implements PaymentPartners{

    @Override
    public void payment(String amount) {
    System.out.println("Payment by JustPay" + amount);
    }
}