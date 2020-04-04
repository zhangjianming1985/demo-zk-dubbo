package com.zjm.my.shop.request;

import java.util.List;

public class ClientRegisterQuantityReq {

    /**
     * 店铺ID集合
     */
    private List<String> shop_ids;
    /**
     * 0=注册用户数
     * 1=新拉用户数
     */
    private Integer type;

    /**
     * 开始日期
     */
    private String start_date;

    /**
     * 结束日期
     */
    private String end_date;
}
