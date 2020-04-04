package com.zjm.my.shop;

public class GetTotalAmountReqDto {
    /**
     * 运营商ID、一分ID、
     */
    private String merchant_id;

    /**
     * 请求类型 0=当前店铺、1=下级所有店铺
     */
    private String req_type;

    /**
     * 开始日期
     */
    private String start_date;

    /**
     * 结束日期
     */
    private String end_date;
}
