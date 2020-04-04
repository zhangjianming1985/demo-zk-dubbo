package com.zjm.my.shop.response;

import java.util.List;

public class GetPayAmountResp {
    /**
     * 支付金额
     */
    private List<PayAmount> shop_amount;


    public static class PayAmount{
         String shop_id;
         double amount;
    }
}
