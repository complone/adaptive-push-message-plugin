/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.example.observer.transfer;

/**
 * @author chengxy
 * 2019/10/22
 */
public class Receiver extends Application {

    public Receiver() {
        super.setId();
    }

    public Object haa(TransferObject c) {
        System.out.println("haa: " + c.getData());
        return c;
    }

    public Object hab(TransferObject c) {
        System.out.println("hab: " + c.getData());
        return c;
    }

    public Object hac(TransferObject c) {
        System.out.println("hac: " + c.getData());
        return c;
    }

}
