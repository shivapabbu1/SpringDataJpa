package com.demo.util;




import java.util.HashMap;
import java.util.Map;

import com.demo.Entity.PaymentInfo;

public class PaymentValidation {

     private static Map<String ,Double> paymentDetails = new HashMap<>();

     static {
         paymentDetails.put("Mobile",20000.0);
         paymentDetails.put("Laptop",60000.0);
         paymentDetails.put("Tablet",30000.0);
         paymentDetails.put("Charger",1000.0);

     }
     public static boolean validatePaymentInfo(PaymentInfo  paymentInfo ){
     if(paymentInfo.getAmount() <paymentDetails.get(paymentInfo.getProductName()))   {
         throw new ErrorException("insufficient amount");
     }
     else {
         return true;
     }
     }
}