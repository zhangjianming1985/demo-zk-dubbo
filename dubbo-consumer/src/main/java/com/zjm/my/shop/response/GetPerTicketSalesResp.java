package com.zjm.my.shop.response;

import java.util.List;

public class GetPerTicketSalesResp {

    /**
     * 客单价
     */
    private List<PerTicketSales> per_ticket_sales;


    public static class PerTicketSales{
        String shop_id;
        double amount;
    }
}
