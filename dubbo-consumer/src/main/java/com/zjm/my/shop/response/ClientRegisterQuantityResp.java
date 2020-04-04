package com.zjm.my.shop.response;

import java.util.List;

public class ClientRegisterQuantityResp {
    /**
     * 店铺用户数量
     */
    private List<RegisterClient> client_numbers;


    public static class RegisterClient{
        String shop_id;
        Integer number;
    }
}
