package com.zjm.bean;

/**
 * 库存
 */
public class Stock {
    //库存数量
    private static int num = 1;

    //减少库存数量的方法
    public boolean reduceStock(){
        if (num>0){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num --;
            return true;
        }else{
            return false;
        }
    }
}
