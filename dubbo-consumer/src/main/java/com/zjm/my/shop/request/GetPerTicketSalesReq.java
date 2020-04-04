package com.zjm.my.shop.request;

import java.util.List;

/**
 * 客单价
 */
public class GetPerTicketSalesReq {
    /**
     * 店铺ID集合
     */
    private List<String> shop_ids;

    /**
     * 开始日期
     */
    private String start_date;

    /**
     * 结束日期
     */
    private String end_date;

}
